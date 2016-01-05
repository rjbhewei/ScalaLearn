package com.hewei.closure

/**
  *
  * @author hewei
  *
  * @date 16/1/5  17:15
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestClosure {

  def oncePerSecond() = {
    while (true) {
      println("xxoo")
      Thread.sleep(1000)
    }
  }

  def main(args: Array[String]) = {
    //    oncePerSecond()  //正常使用
    //    oncePerSecond(timeFlies) //闭包
    oncePerSecond(() => println("xxooxxoo")) //匿名   下面需要使用fn()
  }

  def oncePerSecond(fn: () => Unit) {
    while (true) {
      //fn
      fn()
      Thread.sleep(1000)
    }
  }

  def timeFlies() {
    println("xxooxxoo")
  }

}
