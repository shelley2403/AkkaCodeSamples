package n_twitter

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import n_twitter.TwitterClient
import akka.stream.scaladsl.{Flow, Sink, Source}
import twitter4j.Status

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

}
