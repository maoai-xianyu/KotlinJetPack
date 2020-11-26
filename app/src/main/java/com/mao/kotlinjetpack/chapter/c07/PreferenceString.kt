package com.mao.kotlinjetpack.chapter.c07

import android.content.SharedPreferences
import com.mao.kotlinjetpack.App
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @author zhangkun
 * @time 2020/11/26 8:18 PM
 * @Description 只针对于 sp 的String 如果需要针对全部 需要使用泛型
 */

class PreferenceString(
    val name: String,
    val default: String = "",
    val isCommit: Boolean = false,
    val prefs: SharedPreferences = App.prefs
) : ReadWriteProperty<String, String> {

    override fun getValue(thisRef: String, property: KProperty<*>): String {
        return prefs.getString(name, default) ?: default
    }

    override fun setValue(thisRef: String, property: KProperty<*>, value: String) {

        // apply 方式
        prefs.edit().apply {
            putString(name, value)
            if (isCommit) {
                commit()
            } else {
                apply()
            }
        }

        // width 方式
        with(prefs.edit(), {
            putString(name, value)
            if (isCommit) {
                commit()
            } else {
                apply()
            }
        })

        // with 方式
        with(prefs.edit()) {
            putString(name, value)
            if (isCommit) {
                commit()
            } else {
                apply()
            }
        }


    }
}

