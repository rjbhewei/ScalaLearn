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
    P(addVoid) //4  有警告
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
    P(adder(1, 2)) // 普通
    val add2 = adder(1, _: Int) //下划线表示不同上下文中的不同事物
    P(add2(2))
    P(adder2(1)(2)) //两个括号的表示方法
    P(useMap("5","6"))
    P(new BasicsClass("hewei").HE) //面向表达式
  }

  def addOne(m: Int): Int = m + 1

  def addVoid(): Int = 2

  def P(x: scala.Any): Unit = {
    println(x + "--------from :(" + Thread.currentThread().getStackTrace.apply(2).getLineNumber + ") line") //getStackTrace 没有括号无警告
  }

  def adder(m: Int, n: Int): Int = m + n

  def adder2(m: Int)(n: Int): Int = m + n

  def useMap(args: String*) = {
    args.map(
      arg => arg.capitalize
    )
  }


}
