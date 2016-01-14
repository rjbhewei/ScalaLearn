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

  val system = ActorSystem("scala")
  val hello = system.actorOf(Props[Hello], "hello")
  hello ! Greeting("Hello+++++")
  hello ! Greet("xx")
  hello ! Greet("oo")
  hello ! Greeting("hello----")
  hello ! Greet("yyyy")
  hello ! Greet("zzzz")
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
