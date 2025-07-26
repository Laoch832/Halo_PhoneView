package com.halo.blog.utils

import android.util.Log
import com.halo.blog.BuildConfig

/**
 * 日志工具类，提供统一的日志记录功能
 */
object LogUtils {
    private const val TAG = "HaloBlog"
    
    // 是否启用日志（仅在Debug模式下启用）
    private val isLogEnabled = BuildConfig.DEBUG
    
    /**
     * Debug级别日志
     */
    fun d(tag: String = TAG, message: String) {
        if (isLogEnabled) {
            Log.d(tag, message)
        }
    }
    
    /**
     * Info级别日志
     */
    fun i(tag: String = TAG, message: String) {
        if (isLogEnabled) {
            Log.i(tag, message)
        }
    }
    
    /**
     * Warning级别日志
     */
    fun w(tag: String = TAG, message: String) {
        if (isLogEnabled) {
            Log.w(tag, message)
        }
    }
    
    /**
     * Error级别日志
     */
    fun e(tag: String = TAG, message: String, throwable: Throwable? = null) {
        if (isLogEnabled) {
            if (throwable != null) {
                Log.e(tag, message, throwable)
            } else {
                Log.e(tag, message)
            }
        }
    }
    
    /**
     * 网络请求日志
     */
    fun logNetworkRequest(url: String, method: String, headers: Map<String, String>? = null) {
        if (isLogEnabled) {
            d("Network", "=== 网络请求开始 ===")
            d("Network", "URL: $url")
            d("Network", "方法: $method")
            headers?.forEach { (key, value) ->
                d("Network", "请求头: $key = $value")
            }
            d("Network", "=== 网络请求结束 ===")
        }
    }
    
    /**
     * 网络响应日志
     */
    fun logNetworkResponse(url: String, code: Int, message: String, responseTime: Long? = null) {
        if (isLogEnabled) {
            d("Network", "=== 网络响应开始 ===")
            d("Network", "URL: $url")
            d("Network", "状态码: $code")
            d("Network", "响应消息: $message")
            responseTime?.let {
                d("Network", "响应时间: ${it}ms")
            }
            d("Network", "=== 网络响应结束 ===")
        }
    }
    
    /**
     * 网络错误日志
     */
    fun logNetworkError(url: String, error: Throwable) {
        if (isLogEnabled) {
            e("Network", "=== 网络错误 ===")
            e("Network", "URL: $url")
            e("Network", "错误信息: ${error.message}", error)
            e("Network", "=== 网络错误结束 ===")
        }
    }
    
    /**
     * JSON解析错误日志
     */
    fun logJsonError(json: String?, error: Throwable) {
        if (isLogEnabled) {
            e("JSON", "=== JSON解析错误 ===")
            e("JSON", "JSON内容: ${json ?: "null"}")
            e("JSON", "错误信息: ${error.message}", error)
            e("JSON", "=== JSON解析错误结束 ===")
        }
    }
    
    /**
     * 服务器切换日志
     */
    fun logServerSwitch(oldServer: String?, newServer: String) {
        if (isLogEnabled) {
            i("Server", "=== 服务器切换 ===")
            i("Server", "旧服务器: ${oldServer ?: "无"}")
            i("Server", "新服务器: $newServer")
            i("Server", "=== 服务器切换结束 ===")
        }
    }
    
    /**
     * 应用启动日志
     */
    fun logAppStart(isFirstLaunch: Boolean, selectedServer: String?) {
        if (isLogEnabled) {
            i("App", "=== 应用启动 ===")
            i("App", "首次启动: $isFirstLaunch")
            i("App", "选定服务器: ${selectedServer ?: "未设置"}")
            i("App", "Debug模式: ${BuildConfig.DEBUG}")
            i("App", "=== 应用启动结束 ===")
        }
    }
}