package com.hewei.variant

/**
  *
  * @author hewei
  *
  * @date 16/1/5  14:07
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestVariant {
  def main(args: Array[String]) {
    val cv: Covariant[AnyRef] = new Covariant[String] //协变
    val ct: Contravariant[String] = new Contravariant[AnyRef] //逆变
    val a:A=new B()
    val b:B=new B()
  }

  class A {
    def say(): Unit = {
      println("a say")
    }
  }

  class B extends A{
    override def say() = {
      println("b say")
    }
  }

}
