package com.serviveragent.core

import com.serviveragent.core.UUID.*

import scala.util.Try

/** UUID型を持つIdentifierの具象。
  */
case class UUID(value: Raw) extends Identifier[Raw]

object UUID:
  type Raw = java.util.UUID

  def fromString(string: String): Option[UUID] =
    Try(java.util.UUID.fromString(string)).toOption.map(UUID(_))
