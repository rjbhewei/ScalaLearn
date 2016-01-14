package com.hewei.akka

import akka.actor.{Actor, Props, ActorSystem}

/**
  *
  * @author hewei
  *
  * @date 16/1/14  18:11
  *
  * @version 5.0
  *
  * @desc
  *
  */
object Hello2 extends App {

  case class Greeting(greet: String)
  case class Greet(name: String)

  val system = ActorSystem("actor-demo-scala")
  val hello = system.actorOf(Props[Hello], "hello")
  hello ! Greeting("Hello+++++")
  hello ! Greet("Bob")
  hello ! Greet("Alice")
  hello ! Greeting("hello----")
  hello ! Greet("Alice")
  hello ! Greet("Bob")
  Thread sleep 1000
  system terminate()

  class Hello extends Actor {
    var greeting = ""
    def receive = {
      case Greeting(greet) => greeting = greet
      case Greet(name) => println(s"$greeting $name")
    }
  }
}
