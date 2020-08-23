package com.serviveragent.core

/**
 * Entityを表す抽象
 *
 */
/*
example:
  case class User(id: UserId, name: String) extends Entity
 */
trait Entity {
  def id: Identifier[_]

  def sameIdentityAs(that: Entity): Boolean = {
    this.getClass == that.getClass && this.id == that.id
  }
}



