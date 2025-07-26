package com.halo.blog

import android.app.Application
import com.halo.blog.utils.AutoUpdateManager
import com.halo.blog.utils.PreferenceManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HaloBlogApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
        
        // 初始化自动更新功能
        initAutoUpdate()
    }
    
    private fun initAutoUpdate() {
        val preferenceManager = PreferenceManager(this)
        val autoUpdateManager = AutoUpdateManager(this)
        
        // 如果用户之前开启了自动更新，重新启动任务
        if (preferenceManager.isAutoUpdateEnabled()) {
            autoUpdateManager.startAutoUpdate()
        }
    }
}