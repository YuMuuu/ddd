package com.serviveragent.core

//todo: Fに制約(mapとfmapを持っている)をつけたい
//案1 catsの型を利用する
//懸念: catsに依存していないライブラリの場合この抽象が利用できなくなる

//案2 構造的部分型でFがmap,fmapのメソッドを持っている型と明示する
//例: F[_] <: {def map[A, B](fa: F[A])(f: A => B): F[B], def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]}
//懸念: パフォーマンス上の問題(噂によるとメソッド呼び出しが41倍遅くなる)

trait Repository[F[_], ID <: Identifier[_], AG <: AggregateRootEntity[ID]]{
  def findById(id: ID): F[Vector[AG]]
  def store(entity: AG): F[Unit]
  def delete(id: ID): F[Unit]
}
