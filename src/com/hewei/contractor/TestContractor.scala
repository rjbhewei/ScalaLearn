package com.hewei.contractor

/**
  *
  * @author hewei
  *
  * @date 16/1/6  11:36
  *
  * @version 5.0
  *
  * @desc
  *
  */
class TestContractor(var xx: Int, oo: Int) {

  def this(xx: Int) = this(xx, 1)

  def this() = this(1)

  def getXx = xx

  def setXx(value: Int) = xx = value
}
