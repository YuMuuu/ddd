package com.serviveragent.core

import cats.effect.Sync

/** UUIDを利用したIdentifierを生成するIdGenerator
  */
final class UUIDGenerator[F[_]](using F: Sync[F]) extends IdGenerator[F, UUID]:

  override def generate: F[UUID] =
    F.delay(UUID(java.util.UUID.randomUUID()))

object UUIDGenerator:
  def apply[F[_]](using Sync[F]): UUIDGenerator[F] =
    new UUIDGenerator[F]
