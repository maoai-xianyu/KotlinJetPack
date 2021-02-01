package com.mao.kotlinjetpack.chapter.c09

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 *
 * @author zhangkun
 * @time 2021/2/1 5:28 PM
 * @Description
 */

suspend fun getUserInfo(): String {
    withContext(Dispatchers.IO) {
        delay(1000L)
    }
    return "BoyCoder"
}


suspend fun getFriendList(user: String): String {
    withContext(Dispatchers.IO) {
        delay(1000L)
    }

    return "Tom, Jack"
}


suspend fun getFeedList(list: String): String {
    withContext(Dispatchers.IO) {
        delay(1000L)
    }
    return "{FeedList..}"
}


suspend fun testCoroutine() {
    cLog("start")
    val user = getUserInfo()
    val friendList = getFriendList(user)
    val feedList = getFeedList(friendList)
    cLog(feedList)
}


suspend fun main() {
    testCoroutine()
}


fun cLog(msg: Any) {
    println("${Thread.currentThread().name} msg=$msg")
}

