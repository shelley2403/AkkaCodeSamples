package remoting

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import n_remoting.Worker
import n_remoting.Worker.Work

// Shows Creation Property of Remoting
object MemberServiceRemoteCreation extends App{
  //Create new Actor System
  val config = ConfigFactory.load.getConfig("MemberServiceRemoteCreation")

  val system = ActorSystem("MemberServiceRemoteCreation", config)

  //Create a new remote actor workerActorRemote
  val workerActor = system.actorOf(Props[Worker], "workerActorRemote")

  println(s"Remote path of worker actor is ${workerActor.path}")

  workerActor ! Work("Hi Remote Actor")

  //akka.tcp://MemberService@127.0.0.1:2552/remote/akka.tcp/MemberServiceRemoteCreation@127.0.0.1:2558/user/workerActorRemote

  //Terminal for Remote Service says:
  //I received work message and My ActorRef is: Actor[akka://MemberService/remote/akka.tcp/MemberServiceRemoteCreation@127.0.0.1:2558/user/workerActorRemote#-488490751]

}
