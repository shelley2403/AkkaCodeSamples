package n_remoting

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object MemberServices extends App {

  val config = ConfigFactory.load.getConfig("MemberService")

  //In the MemberService object, we are loading configuration and create the system
  val system = ActorSystem("MemberService", config)

  //Remote Actor System
  val worker = system.actorOf(Props[Worker], "remote-worker")

  //Output: Worker actor path is akka://MemberService/user/remote-worker
  println(s"Worker actor path is ${worker.path}")

  //Two types of remote interactions:
  //1. Lookup: To look up an actor in a remote node with actor selection
  //2. Creation: Create an actor on remote node with actorOf

  //  1. First Run Member Service for actor creation
  //  Then run Member Service Lookup for actor lookup
  //  The worker actor receives the message "I received work message and My ActorRef is: Actor[akka://MemberService/user/remote-worker#-1174716991]"
  //  2. First Run Member Service for actor creation
  //  Then run Member service remote creation for remote actor creation

}
