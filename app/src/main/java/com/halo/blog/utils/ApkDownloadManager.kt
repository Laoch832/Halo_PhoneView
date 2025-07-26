package com.halo.blog.utils

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import androidx.core.content.FileProvider
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.File

/**
 * APK下载管理器
 * 负责下载APK文件并触发安装
 */
class ApkDownloadManager(private val context: Context) {
    
    private val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    
    /**
     * 下载APK文件
     * @param downloadUrl 下载链接
     * @param fileName 文件名
     * @return Flow<DownloadStatus> 下载状态流
     */
    fun downloadApk(downloadUrl: String, fileName: String): Flow<DownloadStatus> = callbackFlow {
        try {
            LogUtils.d("ApkDownloadManager", "开始下载APK: $downloadUrl")
            
            // 创建下载请求
            val request = DownloadManager.Request(Uri.parse(downloadUrl)).apply {
                setTitle("Halo Blog 更新")
                setDescription("正在下载新版本...")
                setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
                setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                setAllowedOverRoaming(false)
            }
            
            // 开始下载
            val downloadId = downloadManager.enqueue(request)
            trySend(DownloadStatus.Started(downloadId))
            
            // 监听下载完成
            val receiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context?, intent: Intent?) {
                    val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                    if (id == downloadId) {
                        val query = DownloadManager.Query().setFilterById(downloadId)
                        val cursor = downloadManager.query(query)
                        
                        if (cursor.moveToFirst()) {
                            val status = cursor.getInt(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_STATUS))
                            when (status) {
                                DownloadManager.STATUS_SUCCESSFUL -> {
                                    val localUri = cursor.getString(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_LOCAL_URI))
                                    LogUtils.d("ApkDownloadManager", "下载完成: $localUri")
                                    trySend(DownloadStatus.Completed(localUri))
                                }
                                DownloadManager.STATUS_FAILED -> {
                                    val reason = cursor.getInt(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_REASON))
                                    LogUtils.e("ApkDownloadManager", "下载失败，原因: $reason")
                                    trySend(DownloadStatus.Failed("下载失败，错误代码: $reason"))
                                }
                            }
                        }
                        cursor.close()
                        context?.unregisterReceiver(this)
                        close()
                    }
                }
            }
            
            // 注册广播接收器
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE), Context.RECEIVER_NOT_EXPORTED)
            } else {
                context.registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
            }
            
            awaitClose {
                try {
                    context.unregisterReceiver(receiver)
                } catch (e: Exception) {
                    // 忽略取消注册时的异常
                }
            }
        } catch (e: Exception) {
            LogUtils.e("ApkDownloadManager", "下载启动失败: ${e.message}")
            trySend(DownloadStatus.Failed(e.message ?: "下载启动失败"))
            close()
        }
    }
    
    /**
     * 安装APK文件
     * @param filePath 文件路径
     */
    fun installApk(filePath: String) {
        try {
            LogUtils.d("ApkDownloadManager", "开始安装APK: $filePath")
            
            // 处理文件路径，支持file://格式和普通路径格式
            val file = if (filePath.startsWith("file://")) {
                File(Uri.parse(filePath).path!!)
            } else {
                File(filePath)
            }
            
            LogUtils.d("ApkDownloadManager", "实际文件路径: ${file.absolutePath}")
            
            if (!file.exists()) {
                LogUtils.e("ApkDownloadManager", "APK文件不存在: ${file.absolutePath}")
                return
            }
            
            // 检查Android 8.0+的未知来源安装权限
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (!context.packageManager.canRequestPackageInstalls()) {
                    LogUtils.w("ApkDownloadManager", "没有未知来源安装权限，引导用户去设置")
                    // 引导用户去设置页面开启未知来源安装权限
                    val settingsIntent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES).apply {
                        data = Uri.parse("package:${context.packageName}")
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(settingsIntent)
                    return
                }
            }
            
            val intent = Intent(Intent.ACTION_VIEW).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                
                // Android 7.0及以上需要使用FileProvider
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val apkUri = FileProvider.getUriForFile(
                        context,
                        "${context.packageName}.fileprovider",
                        file
                    )
                    setDataAndType(apkUri, "application/vnd.android.package-archive")
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                } else {
                    setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive")
                }
            }
            
            context.startActivity(intent)
            LogUtils.d("ApkDownloadManager", "已启动APK安装")
        } catch (e: Exception) {
            LogUtils.e("ApkDownloadManager", "安装APK失败: ${e.message}")
        }
    }
    
    /**
     * 下载状态
     */
    sealed class DownloadStatus {
        data class Started(val downloadId: Long) : DownloadStatus()
        data class Completed(val filePath: String) : DownloadStatus()
        data class Failed(val error: String) : DownloadStatus()
    }
}