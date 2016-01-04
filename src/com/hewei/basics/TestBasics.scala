package com.hewei.basics

/**
  *
  * @author hewei
  *
  * @date 16/1/4  14:04
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestBasics {
  def main(args: Array[String]) {
    val two = 1 + 1
    P(two) //1  变量
    P(addOne(1)) //2  方法
    P(addVoid()) //3
    P(addVoid) //4
    var addOne1 = (x: Int) => x + 1 //5匿名
    P(addOne1(1))
    addOne1 = (x: Int) => {
      println(x)
      x + 1
    }
    P(addOne1(1))
    addOne1 = (x: Int) => {
      x + 1
      println(x)
      x + 2
    }
    P(addOne1(1))
  }

  def addOne(m: Int): Int = m + 1

  def addVoid(): Int = 2

  def P(x:scala.Any): Unit ={
        println(x)
        println("--------")
  }
}
