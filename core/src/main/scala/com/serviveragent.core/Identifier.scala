package com.serviveragent.core

/**
 * Identifierを表す抽象
 *
 * memo: Entityは生成時点でIDが必要なため、Repositoryへ保存する前にアプリケーション側でIDを生成する必要がある。
 * そのため、UUID、ULID、Snowflake IDなど、DBに依存せずアプリケーション側で一意なIDを生成できる方式を想定する。
 */
trait Identifier[A]:
  def value: A
