package com.hewei.basics

/**
  *
  * @author hewei
  *
  * @date 16/1/12  11:00
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestA {
  def main(args: Array[String]) {
    new AA("san").receive
  }

}

class AA(a:String){
  def   receive={
    println(a)
  }
}