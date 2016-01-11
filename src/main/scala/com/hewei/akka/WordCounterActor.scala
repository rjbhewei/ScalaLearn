package com.hewei.akka

import akka.actor.{Props, ActorRef, Actor}

import scala.io.Source


/**
  *
  * @author hewei
  *
  * @date 16/1/11  17:54
  *
  * @version 5.0
  *
  * @desc
  *
  */
case class StartProcessFileMsg()

class WordCounterActor(filename: String) extends Actor {

  def WordCounterActor(){}

  private var running = false
  private var totalLines = 0
  private var linesProcessed = 0
  private var result = 0
  private var fileSender: Option[ActorRef] = None

  def receive = {

    case StartProcessFileMsg() => {
      if (running) {
        // println just used for example purposes;
        // Akka logger should be used instead
        println("Warning: duplicate start message received")
      } else {
        running = true
        fileSender = Some(sender) // save reference to process invoker
        println(filename+"++")

        Source.fromFile(filename).getLines.foreach {
          line => println(line+"--")
        }

        Source.fromFile(filename).getLines.foreach { line =>
          println("wordActor:"+line)
          context.actorOf(Props[StringCounterActor]) ! ProcessStringMsg(line)
          totalLines += 1
        }
      }
    }
    case StringProcessedMsg(words) => {
      result += words
      linesProcessed += 1
      if (linesProcessed == totalLines) {
        fileSender.map(_ ! result) // provide result to process invoker
      }
    }
    case _ => println("message not recognized!")
  }
}
