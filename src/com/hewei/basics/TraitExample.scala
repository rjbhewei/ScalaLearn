package com.hewei.basics

/**
  *
  * @author hewei
  *
  * @date 16/1/4  16:29
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TraitExample {

  trait A {
    def a = 1
  }

  trait B extends A {
    override def a = {
      print("b")
      super.a
    }
  }

  trait C extends A {
    override def a = {
      print("c")
      super.a
    }
  }

  class D extends B with C {
    def apply() = a
  }

  class E extends C with B {
    def apply() = a
  }

  def main(args: Array[String]) {
    println(new D()()) //cb1
    println(new E()()) //bc1
  }

}
