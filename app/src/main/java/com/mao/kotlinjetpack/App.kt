package com.mao.kotlinjetpack

import android.content.Context
import android.content.SharedPreferences

/**
 *
 * @author zhangkun
 * @time 2020/11/26 8:20 PM
 * @Description
 */
object App {
    lateinit var context: Context

    val prefs: SharedPreferences by lazy {
        context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }
}