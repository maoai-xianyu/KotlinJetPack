package com.mao.kotlinjetpack.chapter.c07

import kotlin.reflect.KProperty

/**
 *
 * @author zhangkun
 * @time 2020/11/26 7:46 PM
 * @Description
 */


fun main() {
    UniversalDB(SqlDB()).save()
    UniversalDB(GreenDaoDB()).save()
}

interface DB {
    fun save()
}

class SqlDB() : DB {
    override fun save() { println("save to sql") }
}

class GreenDaoDB() : DB {
    override fun save() { println("save to GreenDao") }
}

class UniversalDB(db: DB) : DB by db


// 代理 MutableList，如果使用java 需要复写ta的所有的方法
class LogList(val log: () -> Unit, val list: MutableList<String>) : MutableList<String> by list{
    fun getAndLog(index: Int): String {
        log()
        return get(index)
    }
}



class Owner {
    var text: String by StringDelegate()
}

class StringDelegate(private var s: String = "Hello") {
    operator fun getValue(thisRef: Owner, property: KProperty<*>): String {
        return s
    }
    operator fun setValue(thisRef: Owner, property: KProperty<*>, value: String?) {
        if (value is String) {
            s = value
        }
    }
}


class TestDelegate {
    companion object {
        fun testPreferences() {
//            var spName: String by Preference(SP_KEY_NAME, "")
//
//            logD(spName)
//
//            spName = "hello"
//            logD(spName)
//
//            spName = "world"
//            logD(spName)
        }
    }
}