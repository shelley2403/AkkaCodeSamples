package n_clustering

import akka.actor.{Actor, ActorSystem, Props, RootActorPath}
import akka.cluster.Cluster
import akka.cluster.ClusterEvent.MemberUp
import com.typesafe.config.ConfigFactory
import n_clustering.Backend.BackendRegistration
import n_clustering.Frontend.Add

//When backend joins the cluster, it needs to detect new potential
//frontend nodes and send a registration msg to tell them to use backend


class Backend extends Actor {
  val cluster = Cluster(context.system)

  //subscribe to cluster changes, MemberUp
  //re-subscribe when restart
  override def preStart(): Unit = {
    cluster.subscribe(self, classOf[MemberUp])
  }

  override def postStop(): Unit = {
    cluster.unsubscribe(self)
  }

  //Handle register message
  override def receive = {
    case Add(num1, num2) =>
      println(s"I'm a backend with path $self and I received add operation")
    case MemberUp(member) =>
      if(member.hasRole("frontend")) {
        context.actorSelection(RootActorPath(member.address) / "user" / "frontend") ! BackendRegistration
      }
  }
}

object Backend {
  //Creates backend actor, takes a port
  def initiate(port: Int): Unit = {
    val config = ConfigFactory.parseString(s"akka.remote.netty.tcp.port=$port").withFallback(ConfigFactory.load().getConfig("Backend"))
    val system = ActorSystem("ClusterSystem", config)
    val Backend = system.actorOf(Props[Backend], name ="Backend")
  }

  case object BackendRegistration

}


