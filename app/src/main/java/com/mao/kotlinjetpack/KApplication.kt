package com.mao.kotlinjetpack

import android.app.Application

/**
 *
 * @author zhangkun
 * @time 2020/11/26 8:21 PM
 * @Description
 */
class KApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        App.context = this
    }
}