package n_remoting

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import n_remoting.Worker.Work

//Shows lookup property of remoting
object MemberServiceLookup extends App{

  //Start Actor System by loading the configs and creating a system
  val config = ConfigFactory.load.getConfig("MemberServiceLookup")

  val system = ActorSystem("MemberServiceLookup", config)

  //Send message to Worker Actor in another Actor System
  //provide remote system host and port
  //We need to send the message to Actor in another Actor System
  val worker = system.actorSelection("akka.tcp://MemberService@127.0.0.1:2552/user/remote-worker")
  // The remote worker actor's path is akka://MemberService/user/remote-worker

  worker ! Work("Hi Remote Actor")

  //Run this object while already running member service actor and see the message in member service
  //I received work message and My ActorRef is: Actor[akka://MemberService/user/remote-worker#1990228162]
  //print(s"Worker actor path is ${worker.path}")

}
