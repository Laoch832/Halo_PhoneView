package com.halo.blog.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halo.blog.data.model.UpdateInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * 更新管理器
 * 统一管理应用更新检查、下载和安装流程
 */
@HiltViewModel
class UpdateManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val updateChecker: UpdateChecker
) : ViewModel() {
    
    private val _updateState = MutableStateFlow<UpdateState>(UpdateState.Idle)
    val updateState: StateFlow<UpdateState> = _updateState.asStateFlow()
    
    private var apkDownloadManager: ApkDownloadManager? = null
    
    /**
     * 检查更新
     */
    fun checkForUpdate() {
        viewModelScope.launch {
            checkForUpdateInternal()
        }
    }
    
    private suspend fun checkForUpdateInternal() {
        try {
            _updateState.value = UpdateState.Checking
            LogUtils.d("UpdateManager", "开始检查更新")
            
            val updateInfo = updateChecker.checkForUpdate()
            val remoteVersion = updateChecker.getLatestVersion()
            if (updateInfo != null) {
                LogUtils.i("UpdateManager", "发现新版本: ${updateInfo.version}")
                _updateState.value = UpdateState.UpdateAvailable(updateInfo)
            } else {
                LogUtils.d("UpdateManager", "当前已是最新版本")
                _updateState.value = UpdateState.NoUpdate(remoteVersion)
            }
        } catch (e: Exception) {
            LogUtils.e("UpdateManager", "检查更新失败: ${e.message}")
            _updateState.value = UpdateState.Error(e.message ?: "检查更新失败")
        }
    }
    
    /**
     * 开始下载更新
     */
    fun startDownload(updateInfo: UpdateInfo) {
        viewModelScope.launch {
            startDownloadInternal(updateInfo)
        }
    }
    
    private suspend fun startDownloadInternal(updateInfo: UpdateInfo) {
        try {
            // 添加代理前缀到下载链接
            val proxyDownloadUrl = "https://proxy.120505.xyz/" + updateInfo.downloadUrl
            LogUtils.d("UpdateManager", "开始下载更新: $proxyDownloadUrl")
            
            val fileName = "HaloBlog_v${updateInfo.version}.apk"
            apkDownloadManager = ApkDownloadManager(context)
            
            apkDownloadManager?.downloadApk(proxyDownloadUrl, fileName)?.collect { status ->
                when (status) {
                    is ApkDownloadManager.DownloadStatus.Started -> {
                        _updateState.value = UpdateState.Downloading(updateInfo, status.downloadId)
                    }
                    is ApkDownloadManager.DownloadStatus.Completed -> {
                        LogUtils.i("UpdateManager", "下载完成，开始安装")
                        _updateState.value = UpdateState.DownloadCompleted(updateInfo, status.filePath)
                        // 自动安装
                        apkDownloadManager?.installApk(status.filePath)
                    }
                    is ApkDownloadManager.DownloadStatus.Failed -> {
                        LogUtils.e("UpdateManager", "下载失败: ${status.error}")
                        _updateState.value = UpdateState.DownloadFailed(updateInfo, status.error)
                    }
                }
            }
        } catch (e: Exception) {
            LogUtils.e("UpdateManager", "下载启动失败: ${e.message}")
            _updateState.value = UpdateState.DownloadFailed(updateInfo, e.message ?: "下载启动失败")
        }
    }
    
    /**
     * 重置更新状态
     */
    fun resetState() {
        _updateState.value = UpdateState.Idle
    }
    
    /**
     * 取消下载
     */
    fun cancelDownload() {
        // 这里可以添加取消下载的逻辑
        _updateState.value = UpdateState.Idle
    }
    
    /**
     * 更新状态
     */
    sealed class UpdateState {
        object Idle : UpdateState()
        object Checking : UpdateState()
        data class NoUpdate(val remoteVersion: String?) : UpdateState()
        data class UpdateAvailable(val updateInfo: UpdateInfo) : UpdateState()
        data class Downloading(val updateInfo: UpdateInfo, val downloadId: Long) : UpdateState()
        data class DownloadCompleted(val updateInfo: UpdateInfo, val filePath: String) : UpdateState()
        data class DownloadFailed(val updateInfo: UpdateInfo, val error: String) : UpdateState()
        data class Error(val message: String) : UpdateState()
    }
}