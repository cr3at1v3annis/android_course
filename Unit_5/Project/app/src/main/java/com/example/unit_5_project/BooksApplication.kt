package com.example.unit_5_project

import android.app.Application
import com.example.unit_5_project.data.AppContainer
import com.example.unit_5_project.data.DefaultAppContainer

class BooksApplication : Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}