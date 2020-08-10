package com.serviveragent

/*
Int型を持つIdentifierの抽象
type UserId = IntId などと type alias を作成して利用する
  example:
    type UserId = IntId
    val userId: UserId = IntId(1000)
    val notAssignedUserId: UserId = IntId.notAssigned
 */
case class IntId(value: Int) extends Identifier[Int] {
  def isAssigned: Boolean = value != -1
}

object IntId {
  def notAssigned: IntId = IntId(-1)
}






