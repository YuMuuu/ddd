package com.serviveragent.core

import cats.effect.kernel.MonadCancel

/** Repositoryを表す抽象
  */
abstract class Repository[
    F[_]: [F[_]] =>> MonadCancel[F, Throwable],
    ID <: Identifier[?],
    AE <: AggregateRootEntity[ID]
]:
  def findById(id: ID): F[Option[AE]]
  def store(entity: AE): F[AE]
  def delete(id: ID): F[Unit]
