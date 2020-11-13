package com.mao.kotlinjetpack.chapter.c04

/**
 *
 * @author zhangkun
 * @time 2020/11/9 9:29 PM
 * @Description
 */

interface Element {
    fun render(builder: StringBuffer, indent: String): String
}


open class BaseElement





/*
fun test() = { i: Int -> i.toString() + "sssss"}
fun teste(i:Int) = run { i.toString() + "sssss" }

fun main(args: Array<String>) {
    val test = test()

    println(test(22))

    println(teste(22))
}
*/


/*
fun main() {
    val htmlContent = html {
        head {
            title { "Kotlin Jetpack In Action" }
        }
        body {
            h1 { "Kotlin Jetpack In Action"}
            p { "-----------------------------------------" }
            p { "A super-simple project demonstrating how to use Kotlin and Jetpack step by step." }
            p { "-----------------------------------------" }
            p { "I made this project as simple as possible," +
                    " so that we can focus on how to use Kotlin and Jetpack" +
                    " rather than understanding business logic." }
            p {"We will rewrite it from \"Java + MVC\" to" +
                    " \"Kotlin + Coroutines + Jetpack + Clean MVVM\"," +
                    " line by line, commit by commit."}
            p { "-----------------------------------------" }
            p { "ScreenShot:" }
            img(src = "https://user-gold-cdn.xitu.io/2020/6/15/172b55ce7bf25419?imageslim",
                alt = "Kotlin Jetpack In Action")
        }
    }.toString()

    println(htmlContent)
}*/
