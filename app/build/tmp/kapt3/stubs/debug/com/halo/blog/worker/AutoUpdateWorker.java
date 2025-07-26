package com.halo.blog.worker;

import java.lang.System;

/**
 * 自动后台更新工作类
 * 每小时执行一次，更新文章列表和缓存
 */
@androidx.hilt.work.HiltWorker()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/halo/blog/worker/AutoUpdateWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "repository", "Lcom/halo/blog/data/repository/HaloRepository;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/halo/blog/data/repository/HaloRepository;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AutoUpdateWorker extends androidx.work.CoroutineWorker {
    private final com.halo.blog.data.repository.HaloRepository repository = null;
    
    @dagger.assisted.AssistedInject()
    public AutoUpdateWorker(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    androidx.work.WorkerParameters params, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.repository.HaloRepository repository) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
}