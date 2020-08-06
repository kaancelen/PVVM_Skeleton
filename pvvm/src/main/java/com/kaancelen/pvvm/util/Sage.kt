package com.kaancelen.pvvm.util

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object Sage {

    lateinit var context: Context
    var debug: Boolean = true

    fun init(context: Context, debug: Boolean) {
        this.context = context
        this.debug = debug
    }
}