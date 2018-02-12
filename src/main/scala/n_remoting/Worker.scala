package n_remoting

import akka.actor.Actor

class Worker extends Actor {
  import Worker._
  override def receive = {
    case msg: Work =>
      println(s"I received work message and My ActorRef is: ${self}")
  }
}

object Worker {
  case class Work (message: String)
}
