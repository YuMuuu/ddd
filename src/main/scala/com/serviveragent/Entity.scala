package com.serviveragent

/*

example:
  case class User(id: UserId, name: String) extends Entity
 */
trait Entity {
  def id: Identifier[_] //todo: 型パラメータに置いたほうが良い？

  def sameIdentityAs(that: Entity): Boolean = {
    this.getClass == that.getClass && this.id == that.id
  }
}



