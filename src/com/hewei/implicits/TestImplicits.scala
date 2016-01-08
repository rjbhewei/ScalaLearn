package com.hewei.implicits


/**
  *
  * @author hewei
  *
  * @date 16/1/8  17:02
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestImplicits {

  def main(args: Array[String]) {
    println(y)
  }

  //    implicit def strToInt(x: String)= x.toInt  //有警告信息
  //    implicit def strToInt(x: String):Int= x.toInt  //有异常
  implicit def strToInt(x: String): Int = Integer.parseInt(x)

  val y: Int = "123"

}
