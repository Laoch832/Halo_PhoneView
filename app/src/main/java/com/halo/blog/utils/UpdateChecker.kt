package com.halo.blog.utils

import android.content.Context
import com.halo.blog.BuildConfig
import com.halo.blog.data.api.UpdateApiService
import com.halo.blog.data.model.UpdateInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 更新检查器
 * 负责检查应用是否有新版本可用
 */
@Singleton
class UpdateChecker @Inject constructor(
    private val updateApiService: UpdateApiService
) {
    
    companion object {
        // GitHub API URLs
        private const val PRIMARY_API_URL = "https://api.github.com/repos/Laoch832/Halo_PhoneView/releases/latest"
        private const val PROXY_API_URL = "https://proxy.120505.xyz/https://api.github.com/repos/Laoch832/Halo_PhoneView/releases/latest"
    }
    
    /**
     * 检查是否有新版本可用
     * @return UpdateInfo 如果有新版本，null 如果没有或检查失败
     */
    suspend fun checkForUpdate(): UpdateInfo? = withContext(Dispatchers.IO) {
        try {
            LogUtils.d("UpdateChecker", "开始检查更新...")
            
            // 首先尝试主要API
            var updateInfo = tryGetUpdateInfo(PRIMARY_API_URL)
            
            // 如果主要API失败，尝试代理API
            if (updateInfo == null) {
                LogUtils.d("UpdateChecker", "主要API失败，尝试代理API")
                updateInfo = tryGetUpdateInfo(PROXY_API_URL)
            }
            
            if (updateInfo != null) {
                // 检查版本是否比当前版本新
                if (isNewerVersion(updateInfo.version, BuildConfig.VERSION_NAME)) {
                    LogUtils.i("UpdateChecker", "发现新版本: ${updateInfo.version}")
                    return@withContext updateInfo
                } else {
                    LogUtils.d("UpdateChecker", "当前已是最新版本:本地${BuildConfig.VERSION_NAME} 远程${updateInfo.version}")
                }
            }
            
            return@withContext null
        } catch (e: Exception) {
            LogUtils.e("UpdateChecker", "检查更新失败: ${e.message}")
            return@withContext null
        }
    }
    
    /**
     * 尝试从指定URL获取更新信息
     */
    private suspend fun tryGetUpdateInfo(url: String): UpdateInfo? {
        return try {
            val response = updateApiService.getLatestRelease(url)
            if (response.isSuccessful) {
                val release = response.body()
                if (release != null) {
                    UpdateInfo.fromGitHubRelease(release)
                } else {
                    LogUtils.w("UpdateChecker", "API响应为空")
                    null
                }
            } else {
                LogUtils.w("UpdateChecker", "API请求失败: ${response.code()} - ${response.message()}")
                null
            }
        } catch (e: Exception) {
            LogUtils.e("UpdateChecker", "请求失败: ${e.message}")
            null
        }
    }
    
    /**
     * 获取最新版本号（不进行版本比较）
     * @return 远程最新版本号，如果获取失败返回null
     */
    suspend fun getLatestVersion(): String? = withContext(Dispatchers.IO) {
        try {
            LogUtils.d("UpdateChecker", "获取远程版本号...")
            
            // 首先尝试主要API
            var updateInfo = tryGetUpdateInfo(PRIMARY_API_URL)
            
            // 如果主要API失败，尝试代理API
            if (updateInfo == null) {
                LogUtils.d("UpdateChecker", "主要API失败，尝试代理API")
                updateInfo = tryGetUpdateInfo(PROXY_API_URL)
            }
            
            return@withContext updateInfo?.version
        } catch (e: Exception) {
            LogUtils.e("UpdateChecker", "获取远程版本号失败: ${e.message}")
            return@withContext null
        }
    }
    
    /**
     * 比较版本号
     * @param newVersion 新版本号
     * @param currentVersion 当前版本号
     * @return true 如果新版本更新
     */
    private fun isNewerVersion(newVersion: String, currentVersion: String): Boolean {
        return try {
            // 移除版本号前的 'v' 前缀
            val cleanNewVersion = newVersion.removePrefix("v")
            val cleanCurrentVersion = currentVersion.removePrefix("v")
            
            // 提取纯数字版本号（移除后缀如-debug, -alpha等）
            val newVersionCore = cleanNewVersion.split("-")[0]
            val currentVersionCore = cleanCurrentVersion.split("-")[0]
            
            // 分割版本号
            val newParts = newVersionCore.split(".").map { it.toIntOrNull() ?: 0 }
            val currentParts = currentVersionCore.split(".").map { it.toIntOrNull() ?: 0 }
            
            // 补齐版本号长度
            val maxLength = maxOf(newParts.size, currentParts.size)
            val newVersionParts = newParts + List(maxLength - newParts.size) { 0 }
            val currentVersionParts = currentParts + List(maxLength - currentParts.size) { 0 }
            
            // 逐个比较版本号
            for (i in 0 until maxLength) {
                when {
                    newVersionParts[i] > currentVersionParts[i] -> return true
                    newVersionParts[i] < currentVersionParts[i] -> return false
                }
            }
            
            false // 版本号相同
        } catch (e: Exception) {
            LogUtils.e("UpdateChecker", "版本号比较失败: ${e.message}")
            false
        }
    }
}