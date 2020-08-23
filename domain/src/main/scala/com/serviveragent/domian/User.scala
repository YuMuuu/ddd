package com.serviveragent.domian

import com.serviveragent.core.Entity
import com.serviveragent.domian.domain.UserId

case class User(id: UserId, name: String) extends Entity

