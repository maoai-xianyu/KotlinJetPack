package com.mao.kotlinjetpack.entity

import java.util.*

/**
 * 尽可能消灭可变性(Mutability)
 */

open class User(
    val id: String? = null,
    val login: String? = null,
    val avatar_url: String? = null,
    val name: String? = null,
    val company: String? = null,
    val blog: String? = null,
    val lastRefresh: Date? = null
)