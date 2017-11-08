import akka.actor.{Actor, ActorSystem, Props}

// Define Actor Messages
case class WhoToGreet(who: String)

// Define Greeter Actor
// The actor is an object which encapsulates state and behavior. They communicate by exchanging messages
class Greeter extends Actor {
  def receive = {
    case WhoToGreet(message) => println(s"Hello $message")
    case someString: String => println(s"Hello $someString")
  }
}

object HelloAkka extends App {

  // Create the 'hello akka' actor system
  // Is the root on actors structure
  // The actor system as a collaborating failure ensemble of actors is the natural unit for managing shared facilities like scheduling services, configuration, and logging
  // Components of actor system : Dead letter office (message for actor not running or dead goes here), User guardian Actor (parent of all actors), system guardian actor (internal actors that akka creates)
  // Event system : main event bus of each actor system. Used to log messages and dead letters. can be used to publish message to entire actor system
  // Scheduler : Responsible for scheduling things that may arise in future
  // Configuration : Access from actor system

  val actorSystem = ActorSystem("Hello-Akka")

  val greeter = actorSystem.actorOf(Props[Greeter], "greeter")
  // Create the 'greeter' actor

  // Send WhoToGreet Message to actor
  greeter ! WhoToGreet("akka")
  greeter ! "Hi There"

  // Actor Components and lifecycle
  // Actor is a black box consists of actor instance (contains state and behavior), mail box (connects sender and receiver, each actor has
  // exactly one mailbox to which all senders enqueue messages) , dispatcher (engine of the machine), Actor reference is interface to box
  // Outside world ---- sends message to---> Actor ref ----dispatch---> Message dispatcher ----Runs/Enqueue----> Mail box ---Deque/Invoke---> Actor

  // Lifecycle
  // Initialized --prestart()--> started ----stop----> stopped ----postStop()---> Terminated


}
