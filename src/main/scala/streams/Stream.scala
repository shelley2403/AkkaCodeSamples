package streams

import akka.NotUsed
import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}

object Stream extends App {

  implicit val system = ActorSystem("test")

  //Dispatcher is the engine of the machine
  //Implements executionService and hence used to run Future invocations
  //Every actorsystem has default dispatcher in case nothing else is configured; by default is fork-join executor
  //The fork/join framework is an implementation of the ExecutorService interface that helps you take advantage of multiple processors

  import system.dispatcher
  implicit val materializer = ActorMaterializer.apply()

  //Source
  val input = Source(1 to 100)

  //Flow
  val normalize:Flow[Int, Int, NotUsed] = Flow[Int].map(_*2)

  //Sink
  val output = Sink.foreach[Int](println(_))

//  input.via(normalize).to(output).run()

  input.via(normalize).runWith(output)(materializer).andThen {
    case _ => system.terminate()
  }
}
