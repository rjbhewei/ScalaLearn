package com.hewei.akka

import akka.actor.Actor

/**
  *
  * @author hewei
  *
  * @date 16/1/11  17:47
  *
  * @version 5.0
  *
  * @desc
  *
  */

case class ProcessStringMsg(string: String)

case class StringProcessedMsg(words: Integer)

class StringCounterActor extends Actor {
  def receive = {
    case ProcessStringMsg(string) => {
      val wordsInLine = string.split(" ").length
      sender ! StringProcessedMsg(wordsInLine)
    }
    case _ => println("Error: message not recognized")
  }
}
