package com.hewei.basics

/**
  *
  * @author hewei
  *
  * @date 16/1/11  17:26
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestCaseClass {
  def main(args: Array[String]) {
    val x = Case1(1)
    println(x.x)
  }
}

case class Case1(x: Int)

