package com.halo.blog.utils

import android.content.Context

object UrlUtils {
    
    /**
     * 构建完整的图片URL
     * @param context 上下文
     * @param imageUrl 图片URL（可能是相对路径或完整URL）
     * @return 完整的图片URL
     */
    fun buildImageUrl(context: Context, imageUrl: String?): String? {
        if (imageUrl.isNullOrBlank()) return null
        
        // 如果已经是完整的URL，直接返回
        if (imageUrl.startsWith("http://") || imageUrl.startsWith("https://")) {
            return imageUrl
        }
        
        // 获取基础URL
        val preferenceManager = PreferenceManager(context)
        val baseUrl = preferenceManager.getSelectedServer() ?: "https://demo.halo.run/"
        val finalBaseUrl = if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/"
        
        // 处理相对路径
        val cleanImageUrl = if (imageUrl.startsWith("/")) {
            imageUrl.substring(1) // 移除开头的 /
        } else {
            imageUrl
        }
        
        return "$finalBaseUrl$cleanImageUrl"
    }
    
    /**
     * 构建完整的API URL
     * @param context 上下文
     * @param apiPath API路径
     * @return 完整的API URL
     */
    fun buildApiUrl(context: Context, apiPath: String): String {
        val preferenceManager = PreferenceManager(context)
        val baseUrl = preferenceManager.getSelectedServer() ?: "https://demo.halo.run/"
        val finalBaseUrl = if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/"
        
        val cleanApiPath = if (apiPath.startsWith("/")) {
            apiPath.substring(1)
        } else {
            apiPath
        }
        
        return "$finalBaseUrl$cleanApiPath"
    }
    
    /**
     * 获取基础URL
     * @param context 上下文
     * @return 基础URL
     */
    fun getBaseUrl(context: Context): String? {
        val preferenceManager = PreferenceManager(context)
        val baseUrl = preferenceManager.getSelectedServer() ?: "https://demo.halo.run/"
        return if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/"
    }
}