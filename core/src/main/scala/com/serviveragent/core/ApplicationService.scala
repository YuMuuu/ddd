package com.serviveragent.core

/** DomainServiceや外部IOなどを実行するApplication Serviceを表す抽象
  */
trait ApplicationService[F[_], In, Out]:
  def run(arg: In): F[Out]
