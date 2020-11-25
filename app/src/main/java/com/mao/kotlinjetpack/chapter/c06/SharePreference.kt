package com.mao.kotlinjetpack.chapter.c06


/**
 *
 * @author zhangkun
 * @time 2020/11/25 9:05 PM
 * @Description
 */

import android.annotation.SuppressLint
import android.content.SharedPreferences

@SuppressLint("ApplySharedPref")
inline fun SharedPreferences.edit(
        commit: Boolean = false,
        action: SharedPreferences.Editor.() -> Unit
) {
    val editor = edit()
    action(editor)
    if (commit) {
        editor.commit()
    } else {
        editor.apply()
    }
}