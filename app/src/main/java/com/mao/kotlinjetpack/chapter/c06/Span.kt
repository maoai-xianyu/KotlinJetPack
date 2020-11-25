package com.mao.kotlinjetpack.chapter.c06

/**
 *
 * @author zhangkun
 * @time 2020/11/25 9:05 PM
 * @Description
 */

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.*

fun ktxSpan(s: CharSequence = SpannableString(""), func: CharSequence.() -> SpannableString) = func(s)
private fun span(s: CharSequence, o: Any): SpannableString = when (s) {
    is SpannableString -> s
    else -> SpannableString(s)
}.apply { setSpan(o, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) }

fun CharSequence.bold(s: CharSequence = this) = span(s, StyleSpan(Typeface.BOLD))
fun CharSequence.italic(s: CharSequence = this) = span(s, StyleSpan(Typeface.ITALIC))
fun CharSequence.underline(s: CharSequence = this) = span(s, UnderlineSpan())
fun CharSequence.strike(s: CharSequence = this) = span(s, StrikethroughSpan())
fun CharSequence.sup(s: CharSequence = this) = span(s, SuperscriptSpan())
fun CharSequence.sub(s: CharSequence = this) = span(s, SubscriptSpan())
fun CharSequence.size(size: Float, s: CharSequence = this) = span(s, RelativeSizeSpan(size))
fun CharSequence.color(color: Int, s: CharSequence = this) = span(s, ForegroundColorSpan(color))
fun CharSequence.background(color: Int, s: CharSequence = this) = span(s, BackgroundColorSpan(color))
fun CharSequence.url(url: String, s: CharSequence = this) = span(s, URLSpan(url))
fun CharSequence.normal(s: CharSequence = this) = span(s, SpannableString(s))
fun CharSequence.append(s: String) = SpannableString(TextUtils.concat(this, s))
fun CharSequence.append(s: SpannableString) = SpannableString(TextUtils.concat(this, s))
