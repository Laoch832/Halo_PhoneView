package com.halo.blog

import android.app.Application
import com.halo.blog.utils.LogUtils
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HaloBlogApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        LogUtils.i("Application", "应用启动")
    }
}