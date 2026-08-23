package com.serviveragent.core

/** Entityを表す抽象
  *
  * example: FollowはUser集約に含まれるEntityとしてUserIdで識別する
  *
  * {{{
  * case class Follow(
  *     id: UserId,
  *     followList: List[UserId]
  * ) extends Entity[UserId]
  * }}}
  */
trait Entity[ID <: Identifier[?]]:
  val id: ID

  def sameIdentityAs(that: Entity[ID]): Boolean =
    this.getClass == that.getClass && this.id == that.id
