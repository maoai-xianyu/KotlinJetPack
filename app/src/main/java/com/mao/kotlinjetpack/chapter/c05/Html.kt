package com.mao.kotlinjetpack.chapter.c05

/**
 *
 * @author zhangkun
 * @time 2020/11/9 9:29 PM
 * @Description
 */

/**
 *  每个节点都需要实现 render 方法
 */
interface Element {
    fun render(builder: StringBuilder, indent: String): String
}


/**
 * 每个节点都有 name，content: <title> Kotlin Jetpack In Action </title>
 */
open class BaseElement(val name: String, var content: String = "") : Element {
    // 每个节点，都会有很多子节点
    val children = ArrayList<Element>()

    // 存放节点参数：<img src= "" alt=""/>，里面的 src，alt
    val hashMap = HashMap<String, String>()

    override fun render(builder: StringBuilder, indent: String): String {
        builder.append("$indent<$name>\n")
        if (content.isNotBlank()) {
            builder.append(" $indent$content\n")
        }
        children.forEach {
            it.render(builder, "$indent ")
        }
        builder.append("$indent</$name>\n")
        return builder.toString()
    }

    // 可以不用
    operator fun String.invoke(block: BaseElement.() -> Unit): BaseElement {
        val element = BaseElement(this)
        element.block()
        this@BaseElement.children += element
        return element
    }

    // 可以不用
    operator fun String.invoke(value: String) {
        this@BaseElement.hashMap[this] = value
    }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }

    // 替换 h1 p tilel
    protected fun <T : BaseElement> initString(element: T, block: T.() -> String): T {
        val content = element.block()
        element.content = content
        children += element
        return element
    }

    protected fun <T : BaseElement> init(element: T, block: T.() -> Unit): T {
        element.block()
        children += element
        return element
    }
}

class HTML : BaseElement("html") {
    fun head(block: HEAD.() -> Unit) = init(HEAD(), block)

    fun body(block: BODY.() -> Unit) = init(BODY(), block)
}

class HEAD : BaseElement("head") {
    fun title(block: Title.() -> String) = initString(Title(), block)
}

// 这是 Head 里面的 title 标签 <title>
class Title : BaseElement("title")

class BODY : BaseElement("body") {

    fun h1(block: H1.() -> String) = initString(H1(), block)

    fun p(block: P.() -> String): P = initString(P(), block)

    fun img(src: String, alt: String): IMG {
        val img = IMG().apply {
            this.src = src
            this.alt = alt
        }
        this.children += img
        return img

    }
}

class P : BaseElement("p")

class H1 : BaseElement("h1")

class IMG : BaseElement("img") {
    var src: String
        get() = hashMap["src"]!!
        set(value) {
            hashMap["src"] = value
        }

    var alt: String
        get() = hashMap["alt"]!!
        set(value) {
            hashMap["alt"] = value
        }

    override fun render(builder: StringBuilder, indent: String): String {
        builder.append("$indent<$name")
        builder.append(renderAttributes())
        builder.append(" /$name>\n")
        return builder.toString()
    }

    private fun renderAttributes(): String {
        val builder = StringBuilder()
        for ((attr, value) in hashMap) {
            builder.append(" $attr=\"$value\"")
        }
        return builder.toString()
    }


}

fun html(block: HTML.() -> Unit): HTML {
    val html = HTML()
    html.block()
    return html
}


fun main() {
    val htmlContent = html {
        head {
            title { "Kotlin Jetpack In Action" }
        }
        body {
            h1 { "Kotlin Jetpack In Action" }
            p { "-----------------------------------------" }
            p { "A super-simple project demonstrating how to use Kotlin and Jetpack step by step." }
            p { "-----------------------------------------" }
            p {
                "I made this project as simple as possible," +
                        " so that we can focus on how to use Kotlin and Jetpack" +
                        " rather than understanding business logic."
            }
            p {
                "We will rewrite it from \"Java + MVC\" to" +
                        " \"Kotlin + Coroutines + Jetpack + Clean MVVM\"," +
                        " line by line, commit by commit."
            }
            p { "-----------------------------------------" }
            p { "ScreenShot:" }
            img(
                src = "https://user-gold-cdn.xitu.io/2020/6/15/172b55ce7bf25419?imageslim",
                alt = "Kotlin Jetpack In Action"
            )

        }
    }.toString()

    println(htmlContent)
}

