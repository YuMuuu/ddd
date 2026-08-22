package com.serviveragent.core.snapshot

import com.serviveragent.core.{AggregateRootEntity, Identifier}

/** コマンドクエリ責務分離におけるCommandを表す抽象
  *
  * 集約ルートごとの作成、更新、削除を行う
 *
 *  単一DB、またはwrite DBとread replica DBで構成されるシステムを想定する
 *  write DBからread replica DBへの同期はDBの責務とする
 *  CommandModelからEventSubscriberを利用してQueryModelへのデータ更新は行わない
 *
  * example: Tweet集約の作成、更新、削除をCommandとして定義する
  *
  * {{{
  * trait TweetCommand[F[_]] extends Command[F, TweetId, Tweet]
  * }}}
  */
trait Command[
    F[_],
    ID <: Identifier[?],
    AE <: AggregateRootEntity[ID]
]:
  def store(entity: AE): F[AE]
  def delete(id: ID): F[Unit]
