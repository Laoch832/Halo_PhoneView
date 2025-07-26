package com.halo.blog.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/halo/blog/di/UpdateModule;", "", "()V", "provideUpdateApiService", "Lcom/halo/blog/data/api/UpdateApiService;", "updateRetrofit", "Lretrofit2/Retrofit;", "provideUpdateChecker", "Lcom/halo/blog/utils/UpdateChecker;", "updateApiService", "provideUpdateRetrofit", "okHttpClient", "Lokhttp3/OkHttpClient;", "app_debug"})
@dagger.Module()
public final class UpdateModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.halo.blog.di.UpdateModule INSTANCE = null;
    
    private UpdateModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @UpdateRetrofit()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final retrofit2.Retrofit provideUpdateRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.halo.blog.data.api.UpdateApiService provideUpdateApiService(@org.jetbrains.annotations.NotNull()
    @UpdateRetrofit()
    retrofit2.Retrofit updateRetrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.halo.blog.utils.UpdateChecker provideUpdateChecker(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.api.UpdateApiService updateApiService) {
        return null;
    }
}