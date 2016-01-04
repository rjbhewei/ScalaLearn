package com.hewei.collections

/**
  *
  * @author hewei
  *
  * @date 16/1/4  17:45
  *
  * @version 5.0
  *
  * @desc
  *
  */
object TestCollection {

  val c1 = List(1, 2, 3, 4)
  val c2 = Set(1, 2, 3, 4)
  val c3 = ("localhost", 8080)
  val c4 = Tuple2("localhost", 8080)
  val c5 = {
    "localhost" -> 8081; "localhost" -> 8080
  }
  val c6 = ("localhost" -> 8081, "localhost" -> 8080)
  val c7 = Map("localhost" -> 8081, "localhost" -> 8080)
  val c8 = Map("localhost1" -> 8081, "localhost2" -> 8080)

  //  List(1, 2, 3, 4)--------from :(31) line
  //  1--------from :(32) line
  //  Set(2, 3, 4)--------from :(33) line
  //  false--------from :(34) line
  //  localhost--------from :(35) line
  //  (localhost,8080)--------from :(36) line
  //  (localhost,8080)--------from :(37) line
  //  true--------from :(38) line
  //  ((localhost,8081),(localhost,8080))--------from :(39) line
  //  class scala.Tuple2--------from :(40) line
  //  class scala.Tuple2--------from :(41) line
  //  Map(localhost -> 8080)--------from :(42) line
  //  false--------from :(43) line
  //  8080--------from :(44) line
  //  match--------from :(45) line
  //  List(2, 4, 6, 8)--------from :(46) line
  //  List(2, 4, 6, 8)--------from :(47) line
  //  1234List((1,1), (2,2), (3,3), (4,4))--------from :(49) line
  //  (List(3),List(1, 2, 4))--------from :(50) line
  //  1--------from :(51) line
  //  1--------from :(52) line
  //  List(3, 4)--------from :(53) line
  //  12List(2, 3, 4)--------from :(54) line
  //  List(2, 3, 4)--------from :(55) line
  //  1--1,2--2,4--3,8--4,4--1,3--2,2--4,1--8,
  //  List(List(1, 2, 3, 4), List(1, 2, 3, 4))--------from :(59) line
  //  List(1, 2, 3, 4, 1, 2, 3, 4)--------from :(60) line
  //  flat:List(1, 2, 3, 4)|flat:List(1, 2, 3, 4)|List(2, 4, 6, 8, 2, 4, 6, 8)--------from :(61) line
  //  Map(localhost1 -> 8081)--------from :(62) line
  //  Map(localhost1 -> 8081)--------from :(63) line
  //  l:List()|l:List(8)|l:List(6, 8)|l:List(4, 6, 8)|List(2, 4, 6, 8)--------from :(64) line
  //  List(List(1, 2), 3, 4, 5)--------from :(65) line
  //  List(List(3, 4, 5), 1, 2)--------from :(66) line
  def main(args: Array[String]) {
    P(c1)
    P(c1.head)
    P(c2.tail)
    P(c2(0))
    P(c3._1)
    P(c4)
    P(c5)
    P(c3 == c5)
    P(c6)
    P(c5.getClass)
    P(c6.getClass)
    P(c7)
    P(c7 == c5) //false
    P(c7.getOrElse("localhost", 80))
    P(matchX(c3))
    P(mapDouble(c1))
    P(mapDouble2(c1))
    listForeach(c1)
    P(listZip(c1))
    P(c1.partition(_ % 3 == 0))
    P(c1.find(_ >= 1).get)
    P(c1.find((x: Int) => x >= 1).get)
    P(c1.drop(2))
    P(c1.dropWhile({ i => print(i); i < 2 }))
    P(c1.dropWhile(_ % 2 != 0))
    c1.foldLeft(1)({ (m: Int, n: Int) => print(m + "--" + n + ","); m * 2 })
    c1.foldRight(1)({ (m: Int, n: Int) => print(m + "--" + n + ","); n * 2 })
    println
    P(List(c1, c1))
    P(List(c1, c1).flatten)
    P(List(c1, c1).flatMap({ x => print("flat:" + x + "|"); x.map(_ * 2) })) //先映射后扁平化
    P(c8.filter({ case (host, port) => port > 8080 }))
    P(c8.filter((x: (String, Int)) => x._2 > 8080))
    P(ourMap(c1, mapDouble3))
    P(List[Int](1, 2) :: List[Int](3, 4, 5))
    P(List[Int](3, 4, 5) :: List[Int](1, 2))
  }

  def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
    numbers.foldRight(List[Int]()) { (x: Int, xs: List[Int]) =>
      print("l:" + xs + "|")
      fn(x) :: xs
    }
  }

  def matchX(hostPort: (String, Int)): String = {
    hostPort match {
      case ("localhost", 8080) => "match"
      case (host, port) => "haha" //host port 未定义
      case _ => "no match"
    }
  }

  def mapDouble(x: List[Int]) = x.map((i: Int) => i * 2)

  def mapDouble2(x: List[Int]): List[Int] = {
    x.map(mapDouble3)
  }

  def mapDouble3(x: Int): Int = {
    x * 2
  }

  def listForeach(x: List[Int]): Unit = {
    x.foreach(print)
  }

  def listZip(x: List[Int]): List[AnyRef] = {
    x.zip(c2)
  }

  def P(x: scala.Any): Unit = {
    println(x + "--------from :(" + Thread.currentThread().getStackTrace.apply(2).getLineNumber + ") line") //getStackTrace 没有括号无警告
  }
}
