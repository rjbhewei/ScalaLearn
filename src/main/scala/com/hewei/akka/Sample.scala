package com.hewei.akka

import akka.actor.{Props, ActorSystem}


/**
  *
  * @author hewei
  *
  * @date 16/1/11  17:57
  *
  * @version 5.0
  *
  * @desc
  *
  */
object Sample {

  import akka.util.Timeout
  import scala.concurrent.duration._
  import akka.pattern.ask
  import akka.dispatch.ExecutionContexts._

  implicit val ec = global

  val file = "/Users/colin/work/111"

  def main(args: Array[String]) {
    val system = ActorSystem("System")
    val actor = system.actorOf(Props(classOf[WordCounterActor], file), name = "haha")
    implicit val timeout = Timeout(25 seconds)
    val future = actor ? StartProcessFileMsg()
    future.map { result =>
      println("Total number of words " + result)
      system.shutdown
    }
  }
}
