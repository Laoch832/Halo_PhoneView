package com.halo.blog.utils;

import java.lang.System;

/**
 * 日志工具类，提供统一的日志记录功能
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J$\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\rJ\u0016\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\rJ.\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aJ/\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0002\u0010 J\u0018\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010#\u001a\u00020\u0004J\u0018\u0010$\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/halo/blog/utils/LogUtils;", "", "()V", "TAG", "", "isLogEnabled", "", "d", "", "tag", "message", "e", "throwable", "", "i", "logAppStart", "isFirstLaunch", "selectedServer", "logJsonError", "json", "error", "logNetworkError", "url", "logNetworkRequest", "method", "headers", "", "logNetworkResponse", "code", "", "responseTime", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;)V", "logServerSwitch", "oldServer", "newServer", "w", "app_debug"})
public final class LogUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.halo.blog.utils.LogUtils INSTANCE = null;
    private static final java.lang.String TAG = "HaloBlog";
    private static final boolean isLogEnabled = false;
    
    private LogUtils() {
        super();
    }
    
    /**
     * Debug级别日志
     */
    public final void d(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * Info级别日志
     */
    public final void i(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * Warning级别日志
     */
    public final void w(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * Error级别日志
     */
    public final void e(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable throwable) {
    }
    
    /**
     * 网络请求日志
     */
    public final void logNetworkRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String method, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, java.lang.String> headers) {
    }
    
    /**
     * 网络响应日志
     */
    public final void logNetworkResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String url, int code, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.Nullable()
    java.lang.Long responseTime) {
    }
    
    /**
     * 网络错误日志
     */
    public final void logNetworkError(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable error) {
    }
    
    /**
     * JSON解析错误日志
     */
    public final void logJsonError(@org.jetbrains.annotations.Nullable()
    java.lang.String json, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable error) {
    }
    
    /**
     * 服务器切换日志
     */
    public final void logServerSwitch(@org.jetbrains.annotations.Nullable()
    java.lang.String oldServer, @org.jetbrains.annotations.NotNull()
    java.lang.String newServer) {
    }
    
    /**
     * 应用启动日志
     */
    public final void logAppStart(boolean isFirstLaunch, @org.jetbrains.annotations.Nullable()
    java.lang.String selectedServer) {
    }
}