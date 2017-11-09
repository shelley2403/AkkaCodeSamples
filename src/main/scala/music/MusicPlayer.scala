package music

import akka.actor.{Actor, Props}
import music.MusicController.Play
import music.MusicPlayer.{StartMusic, StopMusic}

object MusicPlayer {
  sealed trait PlayerMsg
  case object StartMusic extends PlayerMsg
  case object StopMusic extends PlayerMsg
}

class MusicPlayer extends Actor {
  override def receive = {
    case StopMusic => println("I don't want to stop music")
    case StartMusic =>
      // breaks actor encapsulation. Never pass actor's this reference to Props
      //      val controller = context.actorOf(Props[MusicController], "musicController")
      //      controller ! Play

      val controller = context.actorOf(MusicController.props, "musicController")
      controller ! Play
  }
}
