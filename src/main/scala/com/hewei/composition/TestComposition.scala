package com.hewei.composition

/**
  *
  * @author hewei
  *
  * @date 16/1/5  11:09
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestComposition {
  val one: PartialFunction[Int, String] = {
    case 1 => "one"
  }
  val other: PartialFunction[Int, String] = {
    case _ => "other"
  }
  val matchX = one orElse other
  val matchY = one.orElse(other)

  def main(args: Array[String]) {
    P(f(g("hewei")))
    var xx = f _ compose g
    P(xx("hewei"))
    xx = f _ andThen g
    P(xx("hewei"))
    P(one.isDefinedAt(1))
    P(one.isDefinedAt(2))
    P(one(1))
    P(matchX(2))
    P(matchY(2))
    P(d(List(1,2,3)))
    P(d(List("1", "2", "3")))
    P(identity("aa"))
  }


  def d[A](l: List[A]) = l.tail

  def f(s: String) = "f(" + s + ")"

  def g(s: String) = "g(" + s + ")"

  def P(x: scala.Any): Unit = {
    println(x + "--------from :(" + Thread.currentThread().getStackTrace.apply(2).getLineNumber + ") line") //getStackTrace 没有括号无警告
  }
}
