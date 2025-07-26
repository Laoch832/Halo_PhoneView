package com.halo.blog.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/halo/blog/utils/PreferenceManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSelectedServer", "", "isFirstLaunch", "", "markAppLaunched", "", "saveSelectedServer", "serverUrl", "Companion", "app_release"})
public final class PreferenceManager {
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.halo.blog.utils.PreferenceManager.Companion Companion = null;
    private static final java.lang.String KEY_SELECTED_SERVER = "selected_server";
    private static final java.lang.String KEY_FIRST_LAUNCH = "first_launch";
    
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
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/halo/blog/utils/PreferenceManager$Companion;", "", "()V", "KEY_FIRST_LAUNCH", "", "KEY_SELECTED_SERVER", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}