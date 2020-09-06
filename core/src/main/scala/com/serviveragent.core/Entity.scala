package com.serviveragent.core


/**
 * Entityを表す抽象
 *
 */
/*
example:
  case class User(id: UserId, name: String) extends Entity[UserId]
 */
trait Entity {
  type ID <: Identifier[_]
  def id: ID

//  def sameIdentityAs(that: Entity): Boolean = {
//    this.getClass == that.getClass && this.id == that.id
//  }
}




