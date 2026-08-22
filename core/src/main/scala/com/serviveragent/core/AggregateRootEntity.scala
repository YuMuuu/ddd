package com.serviveragent.core

/** 集約ルートを表す抽象
  *
  * example: TweetはTweetIdで識別し、別集約のUserはUserIdで参照する
  *
  * {{{
  * enum Tweet extends AggregateRootEntity[TweetId]:
  *   case NormalTweet(
  *       id: TweetId,
  *       text: String140,
  *       userId: UserId,
  *       replyTweetTweetId: TweetId
  *   )
  *   case ReTweet(
  *       id: TweetId,
  *       text: String140,
  *       userId: UserId,
  *       reTweetTweetId: TweetId
  *   )
  * }}}
  */
trait AggregateRootEntity[ID <: Identifier[?]] extends Entity[ID]
