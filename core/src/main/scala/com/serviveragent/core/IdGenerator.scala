package com.serviveragent.core

/** Identifierを生成する抽象
  */
trait IdGenerator[F[_], ID <: Identifier[?]]:
  def generate: F[ID]
