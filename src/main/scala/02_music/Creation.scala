package music

import akka.actor.{ActorSystem, Props}
import music.MusicPlayer.{StartMusic, StopMusic}

object Creation extends App {
  val system = ActorSystem("ActorCreation")
  val player = system.actorOf(Props[MusicPlayer], "musicPlayer")
  player ! StartMusic
  player ! StopMusic
}





