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


// 自定义扩展，传入 (User) -> Unit 的函数
fun User.applySelf(block: (user: User) -> Unit): User {

    block(this)

    return this
}

// 上下两者是等价的 这个不需要调用this, 等价于
fun User.applySelfS(block: User.() -> Unit): User {
    block()
    return this
}