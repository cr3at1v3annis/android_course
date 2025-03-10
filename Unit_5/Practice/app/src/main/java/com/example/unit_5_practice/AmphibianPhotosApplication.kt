package com.example.unit_5_practice

import android.app.Application
import com.example.unit_5_practice.data.AppContainer
import com.example.unit_5_practice.data.DefaultAppContainer

class AmphibianPhotosApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}