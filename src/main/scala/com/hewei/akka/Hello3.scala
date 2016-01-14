package com.hewei.akka

import akka.actor.{Actor, Props, ActorRef, ActorSystem}

/**
  *
  * @author hewei
  *
  * @date 16/1/14  18:22
  *
  * @version 5.0
  *
  * @desc
  *
  */
object Hello3 extends App {

  import Greeter._
  val system = ActorSystem("scala")
  val bob = system.actorOf(props("he", "xxxxxxx"))
  val alice = system.actorOf(props("wei", "ooooooo"))
  bob ! Greet(alice)
  alice ! Greet(bob)
  Thread sleep 1000
  system terminate()

  object Greeter {
    case class Greet(peer: ActorRef)
    case object AskName
    case class TellName(name: String)
    def props(name: String, greeting: String) = Props(new Greeter(name, greeting))
  }

  class Greeter(myName: String, greeting: String) extends Actor {
    import Greeter._
    def receive = {
      case Greet(peer) => peer ! AskName
      case AskName => sender ! TellName(myName)
      case TellName(name) => println(s"$greeting, $name")
    }
  }
}
