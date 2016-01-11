package com.hewei.range

import scala.collection.immutable.Range
import scala.collection.immutable.Range.Inclusive

/**
  *
  * @author hewei
  *
  * @date 16/1/6  16:48
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestRange {
  def main(args: Array[String]) {
    f0r(1 to 10)
    f0r(1 to(10, 2))
    f0r(new Inclusive(1, 10, 2))
    for2()
  }

  def f0r(xx: Range.Inclusive): Unit = {
    for (i <- xx) {
      print(i)
    }
    println()
  }

  def log(i : Int) : Boolean = {
    print(i)
    true
  }

  def for2(): Unit = {
    for (i <- 1 to 10; if log(i); xx = ""; if (i % 2) == 0)
      print(i + xx)
    println()
  }

}
