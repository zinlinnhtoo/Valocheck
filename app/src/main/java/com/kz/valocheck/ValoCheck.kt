package com.kz.valocheck

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ValoCheck: Application() {

    override fun onCreate() {
        super.onCreate()
        DarkModeHelper.getInstance(this)
    }
}