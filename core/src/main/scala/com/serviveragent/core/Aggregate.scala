package com.serviveragent.core

/** 集約を表す抽象
  *
  * example: TweetCrudUseCaseが扱うIdentifierと集約ルートを関連付ける
  *
  * {{{
  * trait TweetCrudUseCase extends Aggregate[TweetId, Tweet]
  * }}}
  */
trait Aggregate[ID <: Identifier[?], AR <: AggregateRootEntity[ID]]
