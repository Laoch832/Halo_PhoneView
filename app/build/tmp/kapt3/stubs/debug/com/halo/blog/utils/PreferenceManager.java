package com.halo.blog.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\nJ\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u0017\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\b\u0010\u001a\u001a\u0004\u0018\u00010\fJ\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\b\u0010\u001c\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\n2\u0006\u0010\'\u001a\u00020\fJ\u000e\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u001eJ\u000e\u0010*\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/halo/blog/utils/PreferenceManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "sharedPreferences", "Landroid/content/SharedPreferences;", "cachePostContent", "", "postId", "", "postContent", "Lcom/halo/blog/data/model/PostContent;", "cachePostList", "posts", "", "Lcom/halo/blog/data/model/PostItem;", "clearApiKey", "clearNewVersionInfo", "clearPostCache", "clearPostContentCache", "getApiKey", "getCachedPostContent", "getCachedPostList", "getNewVersionDownloadUrl", "getNewVersionNumber", "getSelectedServer", "hasNewVersion", "", "isAutoUpdateEnabled", "isCacheValid", "isFirstLaunch", "isPostContentCacheValid", "markAppLaunched", "saveApiKey", "apiKey", "saveSelectedServer", "serverUrl", "setAutoUpdateEnabled", "enabled", "setHasNewVersion", "setNewVersionInfo", "version", "downloadUrl", "Companion", "app_debug"})
public final class PreferenceManager {
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.halo.blog.utils.PreferenceManager.Companion Companion = null;
    private static final java.lang.String KEY_SELECTED_SERVER = "selected_server";
    private static final java.lang.String KEY_FIRST_LAUNCH = "first_launch";
    private static final java.lang.String KEY_API_KEY = "api_key";
    private static final java.lang.String KEY_CACHED_POSTS = "cached_posts";
    private static final java.lang.String KEY_CACHE_TIMESTAMP = "cache_timestamp";
    private static final java.lang.String KEY_CACHED_POST_CONTENT = "cached_post_content_";
    private static final java.lang.String KEY_POST_CONTENT_TIMESTAMP = "post_content_timestamp_";
    private static final java.lang.String KEY_AUTO_UPDATE_ENABLED = "auto_update_enabled";
    private static final java.lang.String KEY_HAS_NEW_VERSION = "has_new_version";
    private static final java.lang.String KEY_NEW_VERSION_NUMBER = "new_version_number";
    private static final java.lang.String KEY_NEW_VERSION_DOWNLOAD_URL = "new_version_download_url";
    private static final long CACHE_EXPIRY_TIME = 300000L;
    private final com.google.gson.Gson gson = null;
    
    public PreferenceManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * 保存选定的服务器URL
     */
    public final void saveSelectedServer(@org.jetbrains.annotations.NotNull()
    java.lang.String serverUrl) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedServer() {
        return null;
    }
    
    public final boolean isFirstLaunch() {
        return false;
    }
    
    /**
     * 标记应用已经启动过
     */
    public final void markAppLaunched() {
    }
    
    /**
     * 保存API密钥
     */
    public final void saveApiKey(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey) {
    }
    
    /**
     * 获取API密钥
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getApiKey() {
        return null;
    }
    
    /**
     * 清除API密钥
     */
    public final void clearApiKey() {
    }
    
    /**
     * 缓存文章列表
     */
    public final void cachePostList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.halo.blog.data.model.PostItem> posts) {
    }
    
    /**
     * 获取缓存的文章列表
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.halo.blog.data.model.PostItem> getCachedPostList() {
        return null;
    }
    
    /**
     * 检查缓存是否有效
     */
    public final boolean isCacheValid() {
        return false;
    }
    
    /**
     * 清除文章缓存
     */
    public final void clearPostCache() {
    }
    
    /**
     * 缓存文章详情
     */
    public final void cachePostContent(@org.jetbrains.annotations.NotNull()
    java.lang.String postId, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.PostContent postContent) {
    }
    
    /**
     * 获取缓存的文章详情
     */
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostContent getCachedPostContent(@org.jetbrains.annotations.NotNull()
    java.lang.String postId) {
        return null;
    }
    
    /**
     * 检查文章详情缓存是否有效
     */
    public final boolean isPostContentCacheValid(@org.jetbrains.annotations.NotNull()
    java.lang.String postId) {
        return false;
    }
    
    /**
     * 清除指定文章的详情缓存
     */
    public final void clearPostContentCache(@org.jetbrains.annotations.NotNull()
    java.lang.String postId) {
    }
    
    /**
     * 设置自动后台更新开关
     */
    public final void setAutoUpdateEnabled(boolean enabled) {
    }
    
    /**
     * 获取自动后台更新开关状态
     */
    public final boolean isAutoUpdateEnabled() {
        return false;
    }
    
    /**
     * 设置是否有新版本
     */
    public final void setHasNewVersion(boolean hasNewVersion) {
    }
    
    /**
     * 检查是否有新版本
     */
    public final boolean hasNewVersion() {
        return false;
    }
    
    /**
     * 保存新版本信息
     */
    public final void setNewVersionInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String version, @org.jetbrains.annotations.NotNull()
    java.lang.String downloadUrl) {
    }
    
    /**
     * 获取新版本号
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNewVersionNumber() {
        return null;
    }
    
    /**
     * 获取新版本下载链接
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNewVersionDownloadUrl() {
        return null;
    }
    
    /**
     * 清除新版本信息
     */
    public final void clearNewVersionInfo() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/halo/blog/utils/PreferenceManager$Companion;", "", "()V", "CACHE_EXPIRY_TIME", "", "KEY_API_KEY", "", "KEY_AUTO_UPDATE_ENABLED", "KEY_CACHED_POSTS", "KEY_CACHED_POST_CONTENT", "KEY_CACHE_TIMESTAMP", "KEY_FIRST_LAUNCH", "KEY_HAS_NEW_VERSION", "KEY_NEW_VERSION_DOWNLOAD_URL", "KEY_NEW_VERSION_NUMBER", "KEY_POST_CONTENT_TIMESTAMP", "KEY_SELECTED_SERVER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}