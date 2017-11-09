package music

import akka.actor.{Actor, ActorSystem, Props}
import music.MusicController.{Play, Stop}
import music.MusicPlayer.{StartMusic, StopMusic}

object Creation extends App {
  val system = ActorSystem("ActorCreation")
  val player = system.actorOf(Props[MusicPlayer], "musicPlayer")
  player ! StartMusic
  player ! StopMusic
}





