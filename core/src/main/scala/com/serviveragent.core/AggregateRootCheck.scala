package com.serviveragent.core

/**
 * ある集約ルートが別の集約ルートを直接フィールドに持っていないかをコンパイル時に検査する。
 */
trait AggregateRootCheck[A]

object AggregateRootCheck:
  import scala.compiletime.{erasedValue, error}
  import scala.deriving.Mirror

  inline def checkElem[T](): Unit =
    inline erasedValue[T] match
      case _: AggregateRootEntity[?] =>
        error("AggregateRoot can't have another AggregateRoot")
      case _ => ()

  inline def checkElems[Elems <: Tuple](): Unit =
    inline erasedValue[Elems] match
      case _: (t *: ts) =>
        checkElem[t]()
        checkElems[ts]()
      case _ => ()

  inline given derived[T <: AggregateRootEntity[?]](using
      mirror: Mirror.Of[T]
  ): AggregateRootCheck[T] =
    new AggregateRootCheck[T]:
      inline mirror match
        case product: Mirror.ProductOf[T] =>
          checkElems[product.MirroredElemTypes]()
        case _ => ()
