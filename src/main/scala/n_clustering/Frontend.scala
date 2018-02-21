package n_clustering

import akka.actor.{Actor, ActorRef, ActorSystem, Props, Terminated}
import com.typesafe.config.ConfigFactory
import n_clustering.Backend.BackendRegistration
import n_clustering.Frontend.Add

import scala.util.Random

//FrontEnd nodes receives messages and delegates it to registered backend
class Frontend extends Actor {
  var backends = IndexedSeq.empty[ActorRef]

  //Handle Add message
  override def receive = {
    case Add if backends.isEmpty =>
      println(s"Service unavilable. cluster doesnt have backend node")
    case addOp: Add =>
      //Front end has many backends, select one randomly and forward a message
      println("Frontend: I will forward add operation to backend node to handle it.")
      backends(Random.nextInt(backends.size)) ! addOp

      //Frontend received the backendRegistration message and backend doesn't exist
      // add to backends and watch it
    case BackendRegistration if !backends.contains(sender()) =>
      backends = backends :+ sender()
    context watch sender
      //when one of the watching actors have terminated, remove it from backends
    case Terminated(a) =>
      backends = backends.filterNot(_ == a)
  }
}

object Frontend {
  private var frontend: ActorRef = _
  def initiate() = {
    val config = ConfigFactory.load().getConfig("Frontend")
    val system = ActorSystem("ClusterSystem", config)
    frontend = system.actorOf(Props[Frontend], name = "frontend")
  }

  def getFrontEnd = frontend
  case class Add(xs: Int*)
}
