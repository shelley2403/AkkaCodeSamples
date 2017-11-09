package basics

import akka.actor.Actor

// Define Greeter Actor
// The actor is an object which encapsulates state and behavior. They communicate by exchanging messages
class Greeter extends Actor {
  def receive = {
    case WhoToGreet(message) => println(s"Hello $message")
    case someString: String => println(s"Hello $someString")
  }
}
