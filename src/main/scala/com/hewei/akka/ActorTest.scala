package com.hewei.akka

import akka.actor.{ActorSystem, Props, Actor}
import akka.event.Logging

/**
  *
  * @author hewei
  *
  * @date 16/1/12  15:52
  *
  * @version 5.0
  *
  * @desc
  *
  */
class ActorTest extends Actor{
  val log = Logging(context.system, this)
  override def receive = {
    case "test" => log.info("received test");
    case _ => log.info("unknown info")
  }
}
object Test1 extends App{
  val system = ActorSystem("testSystem")
  val actorTest = system.actorOf(Props[ActorTest], name = "actorTest")
  actorTest ! "test"
  system.terminate()
}
