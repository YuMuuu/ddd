package com.serviveragent.core


/**
 * 集約ルートを表す抽象
 *
 */
/*
example:
  case class 注文(
               id: 注文Id,
             ) extends AggregateRootEntity
 */
trait AggregateRootEntity extends Entity
//todo:
// AggregateRootEntityの引数にAggregateRootEntity型の値を代入することができてしまう
// コンパイル時にこれを許さないようにしたい（macroを使う?）







