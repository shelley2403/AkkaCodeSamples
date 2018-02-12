package n_twitter

import akka.{Done, NotUsed}
import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ClosedShape, Graph}
import n_twitter.TwitterClient
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, RunnableGraph, Sink, Source}
import twitter4j.Status

import scala.concurrent.Future

object ReactiveTweets extends App {
  implicit val actorSystem = ActorSystem()
  import actorSystem.dispatcher
  implicit val flowMaterializer = ActorMaterializer.apply()

  val source = Source.fromIterator(() => TwitterClient.receiveTweets("#Akka"))

  val flow = Flow[Status].map{t => Tweet(Author(t.getUser.getName), t.getText)}

  val sink = Sink.foreach(println)

  source.via(flow).runWith(sink).andThen{
    case _=> actorSystem.terminate()
  }

  val tweets: Source[Status, NotUsed] = Source.fromIterator(() => TwitterClient.receiveTweets("#Akka"))
  val writeAuthors: Sink[Author, Future[Done]] = Sink.foreach[Author](println(_))
  val writeHashtags: Sink[List[Hashtag], Future[Done]] = Sink.foreach[List[Hashtag]](println(_))


  //BROADCASTING
  //We dont need asInstanceOf. Just written for indicating that it is a fully connected graph with no unconnected inputs or outputs
  //Closed graph can be transformed into RunnableGraph.fromGraph
  //run() to run the graph to materialize a stream out of it
  //Both Graph and RunnableGraph are immutable, thread-safe, and freely shareable.
  val g = RunnableGraph.fromGraph(GraphDSL.create() { implicit b =>
    import akka.stream.scaladsl.GraphDSL.Implicits._
    val bcast = b.add(Broadcast[Status](2))
    tweets ~> bcast.in
    bcast.out(0) ~> Flow[Status].map(a => Author(a.getUser.getName)) ~> writeAuthors
    bcast.out(1) ~> Flow[Status].map{t => Tweet(Author(t.getUser.getName), t.getText).hashtags.toList} ~> writeHashtags
    ClosedShape
  })

  g.run()

}
