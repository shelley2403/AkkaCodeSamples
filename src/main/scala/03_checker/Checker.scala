package checker

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import checker.Checker.{BlackUser, CheckUser, WhiteUser}
import checker.Recorder.CreateUser
import checker.Storage.AddUser
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global


// Messages are sent to an actor through one of the following methods:
// Tell (!) : (Asynchronous) fire and forget i.e. not interested in the result or return value.
// Ask (?) : (Asynchronous) returns future representing a possible reply

// Recorder : actor responsible for handling user message and sends message to checker actor to see if user is blacklisted or not
// Checker : actor sends black user or white user as response based on if user is in its blacklist
// Storage : actor that receives message from recorder to add white user


case class User(username: String, email: String)

object Checker {

  sealed trait CheckerMsg

  // Checker Message
  case class CheckUser(user: User) extends CheckerMsg

  sealed trait CheckerResponse

  // Checker response
  case class BlackUser(user: User) extends CheckerMsg

  case class WhiteUser(user: User) extends CheckerMsg

  def props = Props[Checker]

}

class Checker extends Actor {

  val blacklist = List(
    User("Adam", "adam@mail.com")
  )

  override def receive = {
    case CheckUser(user) if blacklist.contains(user) => {
      println(s"Checker: $user is blacklisted")
      sender() ! BlackUser(user)
    }
    case CheckUser(user) => {
      println(s"Checker: $user is not blacklisted")
      sender() ! WhiteUser(user)
    }
  }

}

object Storage {

  sealed trait StorageMsg

  // Storage Messages
  case class AddUser(user: User) extends StorageMsg

  def props = Props[Storage]

}

class Storage extends Actor {

  var users = List.empty[User]

  override def receive = {
    case AddUser(user) =>
      println(s"Storage : $user added")
      users = user :: users
  }
}

object Recorder {

  sealed trait RecorderMsg

  // Recorder Message
  case class CreateUser(user: User) extends RecorderMsg

  def props(checker: ActorRef, storage: ActorRef) = Props(new Recorder(checker, storage))
}

class Recorder(checker: ActorRef, storage: ActorRef) extends Actor {

  implicit val timeout = Timeout(5 seconds)

  override def receive = {
    case CreateUser(user) => {
      checker ? CheckUser(user) map {
        case WhiteUser(user) =>
          storage ! AddUser(user)
        case BlackUser(user) =>
          println(s"Recorder $user is blacklisted")
      }
    }
  }
}

object TalkToActor extends App {

  val system = ActorSystem("CheckerSystem")

  val storage = system.actorOf(Storage.props, "storage")
  val checker = system.actorOf(Checker.props, "checker")
  val recorder = system.actorOf(Recorder.props(checker, storage), "recorder")

  recorder ! CreateUser(User("nancy", "nancy@mail.com"))
  recorder ! CreateUser(User("Adam", "adam@mail.com"))

  Thread.sleep(100)
  system.terminate()
}
