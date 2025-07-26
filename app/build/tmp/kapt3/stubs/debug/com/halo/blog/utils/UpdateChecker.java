package com.halo.blog.utils;

import java.lang.System;

/**
 * 更新检查器
 * 负责检查应用是否有新版本可用
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u0004\u0018\u00010\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/halo/blog/utils/UpdateChecker;", "", "updateApiService", "Lcom/halo/blog/data/api/UpdateApiService;", "(Lcom/halo/blog/data/api/UpdateApiService;)V", "checkForUpdate", "Lcom/halo/blog/data/model/UpdateInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestVersion", "", "isNewerVersion", "", "newVersion", "currentVersion", "tryGetUpdateInfo", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
@javax.inject.Singleton()
public final class UpdateChecker {
    private final com.halo.blog.data.api.UpdateApiService updateApiService = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.halo.blog.utils.UpdateChecker.Companion Companion = null;
    private static final java.lang.String PRIMARY_API_URL = "https://api.github.com/repos/Laoch832/Halo_PhoneView/releases/latest";
    private static final java.lang.String PROXY_API_URL = "https://proxy.120505.xyz/https://api.github.com/repos/Laoch832/Halo_PhoneView/releases/latest";
    
    @javax.inject.Inject()
    public UpdateChecker(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.api.UpdateApiService updateApiService) {
        super();
    }
    
    /**
     * 检查是否有新版本可用
     * @return UpdateInfo 如果有新版本，null 如果没有或检查失败
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkForUpdate(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.halo.blog.data.model.UpdateInfo> continuation) {
        return null;
    }
    
    /**
     * 尝试从指定URL获取更新信息
     */
    private final java.lang.Object tryGetUpdateInfo(java.lang.String url, kotlin.coroutines.Continuation<? super com.halo.blog.data.model.UpdateInfo> continuation) {
        return null;
    }
    
    /**
     * 获取最新版本号（不进行版本比较）
     * @return 远程最新版本号，如果获取失败返回null
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLatestVersion(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
    
    /**
     * 比较版本号
     * @param newVersion 新版本号
     * @param currentVersion 当前版本号
     * @return true 如果新版本更新
     */
    private final boolean isNewerVersion(java.lang.String newVersion, java.lang.String currentVersion) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/halo/blog/utils/UpdateChecker$Companion;", "", "()V", "PRIMARY_API_URL", "", "PROXY_API_URL", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}