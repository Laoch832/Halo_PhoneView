package com.halo.blog.ui.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/halo/blog/ui/viewmodel/CommentViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/halo/blog/data/repository/HaloRepository;", "context", "Landroid/content/Context;", "(Lcom/halo/blog/data/repository/HaloRepository;Landroid/content/Context;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/halo/blog/ui/viewmodel/CommentUiState;", "preferenceManager", "Lcom/halo/blog/utils/PreferenceManager;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "clearComments", "", "clearError", "clearSubmitStatus", "loadComments", "postName", "", "page", "", "loadMoreComments", "refreshComments", "submitComment", "commentContent", "app_debug"})
public final class CommentViewModel extends androidx.lifecycle.ViewModel {
    private final com.halo.blog.data.repository.HaloRepository repository = null;
    private final android.content.Context context = null;
    private final com.halo.blog.utils.PreferenceManager preferenceManager = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.halo.blog.ui.viewmodel.CommentUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.halo.blog.ui.viewmodel.CommentUiState> uiState = null;
    
    @javax.inject.Inject()
    public CommentViewModel(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.repository.HaloRepository repository, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.halo.blog.ui.viewmodel.CommentUiState> getUiState() {
        return null;
    }
    
    /**
     * 加载评论
     */
    public final void loadComments(@org.jetbrains.annotations.NotNull()
    java.lang.String postName, int page) {
    }
    
    /**
     * 加载更多评论
     */
    public final void loadMoreComments(@org.jetbrains.annotations.NotNull()
    java.lang.String postName) {
    }
    
    /**
     * 刷新评论
     */
    public final void refreshComments(@org.jetbrains.annotations.NotNull()
    java.lang.String postName) {
    }
    
    /**
     * 清除错误
     */
    public final void clearError() {
    }
    
    /**
     * 清除评论数据
     */
    public final void clearComments() {
    }
    
    /**
     * 发表评论
     */
    public final void submitComment(@org.jetbrains.annotations.NotNull()
    java.lang.String commentContent, @org.jetbrains.annotations.NotNull()
    java.lang.String postName) {
    }
    
    /**
     * 清除提交状态
     */
    public final void clearSubmitStatus() {
    }
}