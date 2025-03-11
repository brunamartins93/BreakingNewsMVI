package com.course.breakingnews.main.application

import android.app.Application
import com.course.breakingnews.di.main.initializeKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin {
            androidContext(this@BaseApplication)
        }
    }
}