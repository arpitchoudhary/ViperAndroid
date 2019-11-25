package com.toi.vipersample

import android.app.Application
import android.content.Context

class Viper : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        var context: Context? = null
    }
}