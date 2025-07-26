package com.halo.blog.utils

import android.content.Context
import androidx.work.*
import com.halo.blog.worker.AutoUpdateWorker
import java.util.concurrent.TimeUnit

/**
 * 自动更新管理器
 * 负责管理后台自动更新任务的启动和停止
 */
class AutoUpdateManager(private val context: Context) {
    
    companion object {
        private const val AUTO_UPDATE_WORK_NAME = "auto_update_work"
        private const val UPDATE_INTERVAL_HOURS = 1L // 每小时更新一次
    }
    
    private val workManager = WorkManager.getInstance(context)
    
    /**
     * 启动自动更新任务
     */
    fun startAutoUpdate() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // 需要网络连接
            .setRequiresBatteryNotLow(true) // 电量不能过低
            .build()
        
        val autoUpdateRequest = PeriodicWorkRequestBuilder<AutoUpdateWorker>(
            UPDATE_INTERVAL_HOURS, TimeUnit.HOURS
        )
            .setConstraints(constraints)
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                WorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.MILLISECONDS
            )
            .build()
        
        workManager.enqueueUniquePeriodicWork(
            AUTO_UPDATE_WORK_NAME,
            ExistingPeriodicWorkPolicy.REPLACE,
            autoUpdateRequest
        )
        
        LogUtils.d("AutoUpdateManager", "已启动自动更新任务，间隔: ${UPDATE_INTERVAL_HOURS}小时")
    }
    
    /**
     * 停止自动更新任务
     */
    fun stopAutoUpdate() {
        workManager.cancelUniqueWork(AUTO_UPDATE_WORK_NAME)
        LogUtils.d("AutoUpdateManager", "已停止自动更新任务")
    }
    
    /**
     * 检查自动更新任务是否正在运行
     */
    fun isAutoUpdateRunning(): Boolean {
        val workInfos = workManager.getWorkInfosForUniqueWork(AUTO_UPDATE_WORK_NAME)
        return try {
            val workInfo = workInfos.get().firstOrNull()
            workInfo?.state == WorkInfo.State.ENQUEUED || workInfo?.state == WorkInfo.State.RUNNING
        } catch (e: Exception) {
            LogUtils.e("AutoUpdateManager", "检查自动更新状态失败: ${e.message}")
            false
        }
    }
    
    /**
     * 立即执行一次更新（用于测试）
     */
    fun executeImmediateUpdate() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        
        val immediateUpdateRequest = OneTimeWorkRequestBuilder<AutoUpdateWorker>()
            .setConstraints(constraints)
            .build()
        
        workManager.enqueue(immediateUpdateRequest)
        LogUtils.d("AutoUpdateManager", "已触发立即更新")
    }
}