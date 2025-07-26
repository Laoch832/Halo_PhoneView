package com.halo.blog.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.halo.blog.data.model.PostItem
import com.halo.blog.data.model.PostContent

class PreferenceManager(context: Context) {
    private val sharedPreferences: SharedPreferences = 
        context.getSharedPreferences("halo_blog_prefs", Context.MODE_PRIVATE)
    
    companion object {
        private const val KEY_SELECTED_SERVER = "selected_server"
        private const val KEY_FIRST_LAUNCH = "first_launch"
        private const val KEY_API_KEY = "api_key"
        private const val KEY_CACHED_POSTS = "cached_posts"
        private const val KEY_CACHE_TIMESTAMP = "cache_timestamp"
        private const val KEY_CACHED_POST_CONTENT = "cached_post_content_"
        private const val KEY_POST_CONTENT_TIMESTAMP = "post_content_timestamp_"
        private const val KEY_AUTO_UPDATE_ENABLED = "auto_update_enabled"
        private const val CACHE_EXPIRY_TIME = 5 * 60 * 1000L // 5分钟缓存过期时间
    }
    
    private val gson = Gson()
    
    /**
     * 保存选定的服务器URL
     */
    fun saveSelectedServer(serverUrl: String) {
        val oldServer = getSelectedServer()
        sharedPreferences.edit()
            .putString(KEY_SELECTED_SERVER, serverUrl)
            .apply()
        
        // 记录服务器切换日志
        LogUtils.logServerSwitch(oldServer, serverUrl)
    }
    
    fun getSelectedServer(): String? {
        return sharedPreferences.getString(KEY_SELECTED_SERVER, null)
    }
    
    fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean(KEY_FIRST_LAUNCH, true)
    }
    
    /**
     * 标记应用已经启动过
     */
    fun markAppLaunched() {
        val isFirstLaunch = isFirstLaunch()
        val selectedServer = getSelectedServer()
        
        sharedPreferences.edit()
            .putBoolean(KEY_FIRST_LAUNCH, false)
            .apply()
        
        // 记录应用启动日志
        LogUtils.logAppStart(isFirstLaunch, selectedServer)
    }
    
    /**
     * 保存API密钥
     */
    fun saveApiKey(apiKey: String) {
        sharedPreferences.edit()
            .putString(KEY_API_KEY, apiKey)
            .apply()
    }
    
    /**
     * 获取API密钥
     */
    fun getApiKey(): String? {
        return sharedPreferences.getString(KEY_API_KEY, null)
    }
    
    /**
     * 清除API密钥
     */
    fun clearApiKey() {
        sharedPreferences.edit()
            .remove(KEY_API_KEY)
            .apply()
    }
    
    /**
     * 缓存文章列表
     */
    fun cachePostList(posts: List<PostItem>) {
        val json = gson.toJson(posts)
        val currentTime = System.currentTimeMillis()
        
        sharedPreferences.edit()
            .putString(KEY_CACHED_POSTS, json)
            .putLong(KEY_CACHE_TIMESTAMP, currentTime)
            .apply()
            
        LogUtils.d("PreferenceManager", "缓存文章列表，数量: ${posts.size}")
    }
    
    /**
     * 获取缓存的文章列表
     */
    fun getCachedPostList(): List<PostItem>? {
        val json = sharedPreferences.getString(KEY_CACHED_POSTS, null) ?: return null
        val cacheTime = sharedPreferences.getLong(KEY_CACHE_TIMESTAMP, 0)
        val currentTime = System.currentTimeMillis()
        
        // 检查缓存是否过期
        if (currentTime - cacheTime > CACHE_EXPIRY_TIME) {
            LogUtils.d("PreferenceManager", "缓存已过期，清除缓存")
            clearPostCache()
            return null
        }
        
        return try {
            val type = object : TypeToken<List<PostItem>>() {}.type
            val posts = gson.fromJson<List<PostItem>>(json, type)
            LogUtils.d("PreferenceManager", "读取缓存文章列表，数量: ${posts.size}")
            posts
        } catch (e: Exception) {
            LogUtils.e("PreferenceManager", "解析缓存文章列表失败: ${e.message}")
            clearPostCache()
            null
        }
    }
    
    /**
     * 检查缓存是否有效
     */
    fun isCacheValid(): Boolean {
        val cacheTime = sharedPreferences.getLong(KEY_CACHE_TIMESTAMP, 0)
        val currentTime = System.currentTimeMillis()
        return currentTime - cacheTime <= CACHE_EXPIRY_TIME
    }
    
    /**
     * 清除文章缓存
     */
    fun clearPostCache() {
        sharedPreferences.edit()
            .remove(KEY_CACHED_POSTS)
            .remove(KEY_CACHE_TIMESTAMP)
            .apply()
        LogUtils.d("PreferenceManager", "清除文章缓存")
    }
    
    /**
     * 缓存文章详情
     */
    fun cachePostContent(postId: String, postContent: PostContent) {
        val json = gson.toJson(postContent)
        val currentTime = System.currentTimeMillis()
        
        sharedPreferences.edit()
            .putString(KEY_CACHED_POST_CONTENT + postId, json)
            .putLong(KEY_POST_CONTENT_TIMESTAMP + postId, currentTime)
            .apply()
            
        LogUtils.d("PreferenceManager", "缓存文章详情，ID: $postId")
    }
    
    /**
     * 获取缓存的文章详情
     */
    fun getCachedPostContent(postId: String): PostContent? {
        val json = sharedPreferences.getString(KEY_CACHED_POST_CONTENT + postId, null) ?: return null
        val cacheTime = sharedPreferences.getLong(KEY_POST_CONTENT_TIMESTAMP + postId, 0)
        val currentTime = System.currentTimeMillis()
        
        // 检查缓存是否过期
        if (currentTime - cacheTime > CACHE_EXPIRY_TIME) {
            LogUtils.d("PreferenceManager", "文章详情缓存已过期，清除缓存，ID: $postId")
            clearPostContentCache(postId)
            return null
        }
        
        return try {
            val postContent = gson.fromJson(json, PostContent::class.java)
            LogUtils.d("PreferenceManager", "读取缓存文章详情，ID: $postId")
            postContent
        } catch (e: Exception) {
            LogUtils.e("PreferenceManager", "解析缓存文章详情失败: ${e.message}")
            clearPostContentCache(postId)
            null
        }
    }
    
    /**
     * 检查文章详情缓存是否有效
     */
    fun isPostContentCacheValid(postId: String): Boolean {
        val cacheTime = sharedPreferences.getLong(KEY_POST_CONTENT_TIMESTAMP + postId, 0)
        val currentTime = System.currentTimeMillis()
        return currentTime - cacheTime <= CACHE_EXPIRY_TIME
    }
    
    /**
     * 清除指定文章的详情缓存
     */
    fun clearPostContentCache(postId: String) {
        sharedPreferences.edit()
            .remove(KEY_CACHED_POST_CONTENT + postId)
            .remove(KEY_POST_CONTENT_TIMESTAMP + postId)
            .apply()
        LogUtils.d("PreferenceManager", "清除文章详情缓存，ID: $postId")
    }
    
    /**
     * 设置自动后台更新开关
     */
    fun setAutoUpdateEnabled(enabled: Boolean) {
        sharedPreferences.edit()
            .putBoolean(KEY_AUTO_UPDATE_ENABLED, enabled)
            .apply()
        LogUtils.d("PreferenceManager", "设置自动后台更新: $enabled")
    }
    
    /**
     * 获取自动后台更新开关状态
     */
    fun isAutoUpdateEnabled(): Boolean {
        return sharedPreferences.getBoolean(KEY_AUTO_UPDATE_ENABLED, false)
    }
}