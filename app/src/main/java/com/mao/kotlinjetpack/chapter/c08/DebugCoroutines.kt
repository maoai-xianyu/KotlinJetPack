package com.mao.kotlinjetpack.chapter.c08

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * @author zhangkun
 * @time 2020/11/27 2:53 PM
 * @Description
 */

fun main() {
    runBlocking<Unit> {
        fun log(msg: Any) {
            println("${Thread.currentThread().name} msg=$msg")
        }

        log(1)

        launch {
            val a = 4
            delay(300)
            log(a)
        }
        launch {
            val b = 3
            delay(200)
            log(b)
        }
        launch {
            val c = 2
            delay(100)
            log(c)
        }
    }
}

/*
// 输出：

1个线程   4个协程
 ↓         ↓
main @coroutine#1 msg=1
main @coroutine#4 msg=2
main @coroutine#3 msg=3
main @coroutine#2 msg=4
*/


