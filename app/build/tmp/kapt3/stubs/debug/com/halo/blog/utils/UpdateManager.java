package com.halo.blog.utils;

import java.lang.System;

/**
 * 更新管理器
 * 统一管理应用更新检查、下载和安装流程
 */
@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0011\u0010\u0013\u001a\u00020\u0011H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018J\u0019\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/halo/blog/utils/UpdateManager;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "updateChecker", "Lcom/halo/blog/utils/UpdateChecker;", "(Landroid/content/Context;Lcom/halo/blog/utils/UpdateChecker;)V", "_updateState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "apkDownloadManager", "Lcom/halo/blog/utils/ApkDownloadManager;", "updateState", "Lkotlinx/coroutines/flow/StateFlow;", "getUpdateState", "()Lkotlinx/coroutines/flow/StateFlow;", "cancelDownload", "", "checkForUpdate", "checkForUpdateInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetState", "startDownload", "updateInfo", "Lcom/halo/blog/data/model/UpdateInfo;", "startDownloadInternal", "(Lcom/halo/blog/data/model/UpdateInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UpdateState", "app_debug"})
public final class UpdateManager extends androidx.lifecycle.ViewModel {
    private final android.content.Context context = null;
    private final com.halo.blog.utils.UpdateChecker updateChecker = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.halo.blog.utils.UpdateManager.UpdateState> _updateState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.halo.blog.utils.UpdateManager.UpdateState> updateState = null;
    private com.halo.blog.utils.ApkDownloadManager apkDownloadManager;
    
    @javax.inject.Inject()
    public UpdateManager(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.halo.blog.utils.UpdateChecker updateChecker) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.halo.blog.utils.UpdateManager.UpdateState> getUpdateState() {
        return null;
    }
    
    /**
     * 检查更新
     */
    public final void checkForUpdate() {
    }
    
    private final java.lang.Object checkForUpdateInternal(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * 开始下载更新
     */
    public final void startDownload(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.UpdateInfo updateInfo) {
    }
    
    private final java.lang.Object startDownloadInternal(com.halo.blog.data.model.UpdateInfo updateInfo, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * 重置更新状态
     */
    public final void resetState() {
    }
    
    /**
     * 取消下载
     */
    public final void cancelDownload() {
    }
    
    /**
     * 更新状态
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState;", "", "()V", "Checking", "DownloadCompleted", "DownloadFailed", "Downloading", "Error", "Idle", "NoUpdate", "UpdateAvailable", "Lcom/halo/blog/utils/UpdateManager$UpdateState$Checking;", "Lcom/halo/blog/utils/UpdateManager$UpdateState$DownloadCompleted;", "Lcom/halo/blog/utils/UpdateManager$UpdateState$DownloadFailed;", "Lcom/halo/blog/utils/UpdateManager$UpdateState$Downloading;", "Lcom/halo/blog/utils/UpdateManager$UpdateState$Error;", "Lcom/halo/blog/utils/UpdateManager$UpdateState$Idle;", "Lcom/halo/blog/utils/UpdateManager$UpdateState$NoUpdate;", "Lcom/halo/blog/utils/UpdateManager$UpdateState$UpdateAvailable;", "app_debug"})
    public static abstract class UpdateState {
        
        private UpdateState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState$Idle;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "()V", "app_debug"})
        public static final class Idle extends com.halo.blog.utils.UpdateManager.UpdateState {
            @org.jetbrains.annotations.NotNull()
            public static final com.halo.blog.utils.UpdateManager.UpdateState.Idle INSTANCE = null;
            
            private Idle() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState$Checking;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "()V", "app_debug"})
        public static final class Checking extends com.halo.blog.utils.UpdateManager.UpdateState {
            @org.jetbrains.annotations.NotNull()
            public static final com.halo.blog.utils.UpdateManager.UpdateState.Checking INSTANCE = null;
            
            private Checking() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState$NoUpdate;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "remoteVersion", "", "(Ljava/lang/String;)V", "getRemoteVersion", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class NoUpdate extends com.halo.blog.utils.UpdateManager.UpdateState {
            @org.jetbrains.annotations.Nullable()
            private final java.lang.String remoteVersion = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.UpdateManager.UpdateState.NoUpdate copy(@org.jetbrains.annotations.Nullable()
            java.lang.String remoteVersion) {
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
            
            public NoUpdate(@org.jetbrains.annotations.Nullable()
            java.lang.String remoteVersion) {
                super();
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getRemoteVersion() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState$UpdateAvailable;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "updateInfo", "Lcom/halo/blog/data/model/UpdateInfo;", "(Lcom/halo/blog/data/model/UpdateInfo;)V", "getUpdateInfo", "()Lcom/halo/blog/data/model/UpdateInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class UpdateAvailable extends com.halo.blog.utils.UpdateManager.UpdateState {
            @org.jetbrains.annotations.NotNull()
            private final com.halo.blog.data.model.UpdateInfo updateInfo = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.UpdateManager.UpdateState.UpdateAvailable copy(@org.jetbrains.annotations.NotNull()
            com.halo.blog.data.model.UpdateInfo updateInfo) {
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
            
            public UpdateAvailable(@org.jetbrains.annotations.NotNull()
            com.halo.blog.data.model.UpdateInfo updateInfo) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.data.model.UpdateInfo component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.data.model.UpdateInfo getUpdateInfo() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState$Downloading;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "updateInfo", "Lcom/halo/blog/data/model/UpdateInfo;", "downloadId", "", "(Lcom/halo/blog/data/model/UpdateInfo;J)V", "getDownloadId", "()J", "getUpdateInfo", "()Lcom/halo/blog/data/model/UpdateInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Downloading extends com.halo.blog.utils.UpdateManager.UpdateState {
            @org.jetbrains.annotations.NotNull()
            private final com.halo.blog.data.model.UpdateInfo updateInfo = null;
            private final long downloadId = 0L;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.UpdateManager.UpdateState.Downloading copy(@org.jetbrains.annotations.NotNull()
            com.halo.blog.data.model.UpdateInfo updateInfo, long downloadId) {
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
            
            public Downloading(@org.jetbrains.annotations.NotNull()
            com.halo.blog.data.model.UpdateInfo updateInfo, long downloadId) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.data.model.UpdateInfo component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.data.model.UpdateInfo getUpdateInfo() {
                return null;
            }
            
            public final long component2() {
                return 0L;
            }
            
            public final long getDownloadId() {
                return 0L;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState$DownloadCompleted;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "updateInfo", "Lcom/halo/blog/data/model/UpdateInfo;", "filePath", "", "(Lcom/halo/blog/data/model/UpdateInfo;Ljava/lang/String;)V", "getFilePath", "()Ljava/lang/String;", "getUpdateInfo", "()Lcom/halo/blog/data/model/UpdateInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class DownloadCompleted extends com.halo.blog.utils.UpdateManager.UpdateState {
            @org.jetbrains.annotations.NotNull()
            private final com.halo.blog.data.model.UpdateInfo updateInfo = null;
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String filePath = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.UpdateManager.UpdateState.DownloadCompleted copy(@org.jetbrains.annotations.NotNull()
            com.halo.blog.data.model.UpdateInfo updateInfo, @org.jetbrains.annotations.NotNull()
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
            
            public DownloadCompleted(@org.jetbrains.annotations.NotNull()
            com.halo.blog.data.model.UpdateInfo updateInfo, @org.jetbrains.annotations.NotNull()
            java.lang.String filePath) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.data.model.UpdateInfo component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.data.model.UpdateInfo getUpdateInfo() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getFilePath() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState$DownloadFailed;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "updateInfo", "Lcom/halo/blog/data/model/UpdateInfo;", "error", "", "(Lcom/halo/blog/data/model/UpdateInfo;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getUpdateInfo", "()Lcom/halo/blog/data/model/UpdateInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class DownloadFailed extends com.halo.blog.utils.UpdateManager.UpdateState {
            @org.jetbrains.annotations.NotNull()
            private final com.halo.blog.data.model.UpdateInfo updateInfo = null;
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String error = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.UpdateManager.UpdateState.DownloadFailed copy(@org.jetbrains.annotations.NotNull()
            com.halo.blog.data.model.UpdateInfo updateInfo, @org.jetbrains.annotations.NotNull()
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
            
            public DownloadFailed(@org.jetbrains.annotations.NotNull()
            com.halo.blog.data.model.UpdateInfo updateInfo, @org.jetbrains.annotations.NotNull()
            java.lang.String error) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.data.model.UpdateInfo component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.data.model.UpdateInfo getUpdateInfo() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component2() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getError() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/halo/blog/utils/UpdateManager$UpdateState$Error;", "Lcom/halo/blog/utils/UpdateManager$UpdateState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.halo.blog.utils.UpdateManager.UpdateState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            @org.jetbrains.annotations.NotNull()
            public final com.halo.blog.utils.UpdateManager.UpdateState.Error copy(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
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
            
            public Error(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
        }
    }
}