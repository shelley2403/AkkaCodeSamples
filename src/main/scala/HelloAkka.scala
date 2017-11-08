import akka.actor.{Actor, ActorSystem, Props}

// Define Actor Messages
case class WhoToGreet(who: String)

// Define Greeter Actor
class Greeter extends Actor {
  def receive = {
    case WhoToGreet(message) => println(s"Hello $message")
    case someString: String => println(s"Hello $someString")
  }
}

object HelloAkka extends App {


  // Create the 'hello akka' actor system
  val actorSystem = ActorSystem("Hello-Akka")

  val greeter = actorSystem.actorOf(Props[Greeter], "greeter")
  // Create the 'greeter' actor

  // Send WhoToGreet Message to actor
  greeter ! WhoToGreet("akka")
  greeter ! "Hi There"


}
