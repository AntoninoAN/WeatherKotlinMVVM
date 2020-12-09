package com.example.toboc.weatherapi.common

import android.app.Application

/**
 * Provide custom app object level for constants
 * changed to Singleton from abstract class
 */
class CustomApp: Application(){
//    private val customApp : CustomApp = CustomApp()

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance : CustomApp
        private set
    }
}
