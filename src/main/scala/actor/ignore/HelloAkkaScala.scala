/*
package actor.play

import akka.actor.{Actor, ActorSystem, Props}


//define actor msg
case class WhoToGreet(who: String)

//define actor
class Greeter extends Actor{
  def receive  = {
    case WhoToGreet(who) =>  println(s"Hello $who " + "from Oren")
  }
}

object HelloAkkaScala extends App {

  // create actor sys
  val system = ActorSystem("Hi-Akka")

  //create greeter actor
  val greeter = system.actorOf(Props[Greeter],"greeter")

  //send msg whoToGreet to Actor
  greeter ! WhoToGreet("Avivit")
}
*/
