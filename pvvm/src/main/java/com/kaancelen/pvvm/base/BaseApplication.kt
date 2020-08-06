package com.kaancelen.pvvm.base

import android.app.Application
import com.kaancelen.pvvm.BuildConfig
import com.kaancelen.pvvm.util.Sage

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Sage.init(applicationContext, BuildConfig.DEBUG)
    }
}