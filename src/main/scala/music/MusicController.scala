package music

import akka.actor.{Actor, Props}
import music.MusicController.{Play, Stop}

object MusicController {
  sealed trait ControllerMsg
  case object Play extends ControllerMsg
  case object Stop extends ControllerMsg

  //Recommended
  def props = Props[MusicController]
}

class MusicController extends Actor {
  override def receive: Receive = {
    case Play => println("Music started ......")
    case Stop => println("Music stopped ......")
    case _=> println("Unknown Message")
  }
}
