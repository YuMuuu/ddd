package com.serviveragent.core.snapshot

/** コマンドクエリ責務分離におけるQueryを表す抽象
  *
  * 表示や検索に最適化されたデータを取得する
  * 集約ルートの復元やDomainServiceによる合成を行わず直接SQLを実行しReadModelを作成する
  */
trait Query[F[_], In, Out]:
  def execute(input: In): F[Out]
