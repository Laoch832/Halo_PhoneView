package com.halo.blog.utils;

import java.lang.System;

/**
 * APK下载管理器
 * 负责下载APK文件并触发安装
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/halo/blog/utils/ApkDownloadManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "downloadManager", "Landroid/app/DownloadManager;", "downloadApk", "Lkotlinx/coroutines/flow/Flow;", "Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus;", "downloadUrl", "", "fileName", "installApk", "", "filePath", "DownloadStatus", "app_debug"})
public final class ApkDownloadManager {
    private final android.content.Context context = null;
    private final android.app.DownloadManager downloadManager = null;
    
    public ApkDownloadManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * 下载APK文件
     * @param downloadUrl 下载链接
     * @param fileName 文件名
     * @return Flow<DownloadStatus> 下载状态流
     */
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.halo.blog.utils.ApkDownloadManager.DownloadStatus> downloadApk(@org.jetbrains.annotations.NotNull()
    java.lang.String downloadUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    /**
     * 安装APK文件
     * @param filePath 文件路径
     */
    public final void installApk(@org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
    }
    
    /**
     * 下载状态
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus;", "", "()V", "Completed", "Failed", "Started", "Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus$Completed;", "Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus$Failed;", "Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus$Started;", "app_debug"})
    public static abstract class DownloadStatus {
        
        private DownloadStatus() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus$Started;", "Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus;", "downloadId", "", "(J)V", "getDownloadId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Started extends com.halo.blog.utils.ApkDownloadManager.DownloadStatus {
            private final long downloadId = 0L;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.ApkDownloadManager.DownloadStatus.Started copy(long downloadId) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public Started(long downloadId) {
                super();
            }
            
            public final long component1() {
                return 0L;
            }
            
            public final long getDownloadId() {
                return 0L;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus$Completed;", "Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus;", "filePath", "", "(Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Completed extends com.halo.blog.utils.ApkDownloadManager.DownloadStatus {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String filePath = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.ApkDownloadManager.DownloadStatus.Completed copy(@org.jetbrains.annotations.NotNull()
            java.lang.String filePath) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public Completed(@org.jetbrains.annotations.NotNull()
            java.lang.String filePath) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getFilePath() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus$Failed;", "Lcom/halo/blog/utils/ApkDownloadManager$DownloadStatus;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Failed extends com.halo.blog.utils.ApkDownloadManager.DownloadStatus {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String error = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.ApkDownloadManager.DownloadStatus.Failed copy(@org.jetbrains.annotations.NotNull()
            java.lang.String error) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public Failed(@org.jetbrains.annotations.NotNull()
            java.lang.String error) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getError() {
                return null;
            }
        }
    }
}