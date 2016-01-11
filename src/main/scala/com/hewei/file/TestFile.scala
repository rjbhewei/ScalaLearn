package com.hewei.file

import java.io.File

import com.hewei.akka.WordCounterActor

import scala.io.Source

/**
  *
  * @author hewei
  *
  * @date 16/1/11  18:16
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestFile {

  val file = "/Users/colin/work/111"

  def main(args: Array[String]): Unit = {
    Source.fromFile(file).getLines.foreach {
      line => println(line+"--")
    }
  }
}
