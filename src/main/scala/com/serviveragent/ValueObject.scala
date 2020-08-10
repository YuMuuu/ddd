package com.serviveragent


/*
 ValueObjectを表す抽象
 example:
   case class User(name: String, password: String) extends ValueObject
 */
//todo: case classに継承させる予定だが振る舞いが変わらないのでいらない？

trait ValueObject {
  override def equals(obj: Any): Boolean = super.equals(obj)
}


