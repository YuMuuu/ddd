package com.serviveragent.core

import com.serviveragent.core.typeclass.{FlatMap, Functor}

//todo: Fの制約は充分か？

trait Repository[F[_] <: Functor[F] with FlatMap[F], AE <: AggregateRootEntity]{
  def findById(id: AE#ID): F[Vector[AE]]
  def store(entity: AE): F[Unit]
  def delete(id: AE#ID): F[Unit]
}
