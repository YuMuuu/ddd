package com.serviveragent.core

/** Repositoryを表す抽象
  */
abstract class Repository[
    F[_],
    ID <: Identifier[?],
    AE <: AggregateRootEntity[ID]
]:
  def findById(id: ID): F[Option[AE]]
  def store(entity: AE): F[AE]
  def delete(id: ID): F[Unit]
