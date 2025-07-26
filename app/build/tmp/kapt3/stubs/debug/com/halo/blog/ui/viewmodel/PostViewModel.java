package com.halo.blog.ui.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u000e\u0010&\u001a\u00020$2\u0006\u0010\'\u001a\u00020\tJ\u000e\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\tJ\b\u0010*\u001a\u00020$H\u0002J\u0006\u0010+\u001a\u00020$J\u000e\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\tJ\u001a\u0010.\u001a\u00020$2\u0006\u0010-\u001a\u00020\t2\b\b\u0002\u0010/\u001a\u00020\u000bH\u0002J>\u00100\u001a\u00020$2\b\b\u0002\u00101\u001a\u00020\u000b2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\t2\b\b\u0002\u00103\u001a\u000204JJ\u00105\u001a\u00020$2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00101\u001a\u00020\u000b2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\t2\b\b\u0002\u00103\u001a\u000204H\u0002J\u0018\u00106\u001a\u00020$2\u0006\u00102\u001a\u00020\t2\b\b\u0002\u00103\u001a\u000204R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001a\u00a8\u00067"}, d2 = {"Lcom/halo/blog/ui/viewmodel/PostViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/halo/blog/data/repository/HaloRepository;", "preferenceManager", "Lcom/halo/blog/utils/PreferenceManager;", "(Lcom/halo/blog/data/repository/HaloRepository;Lcom/halo/blog/utils/PreferenceManager;)V", "_error", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isDetailRefreshing", "", "_isLoading", "_isRefreshing", "_postDetail", "Lcom/halo/blog/data/model/PostDetail;", "_uiState", "Lcom/halo/blog/ui/viewmodel/PostUiState;", "currentCategory", "currentKeyword", "currentPage", "", "currentTag", "error", "Lkotlinx/coroutines/flow/StateFlow;", "getError", "()Lkotlinx/coroutines/flow/StateFlow;", "isDetailRefreshing", "isLastPage", "isLoading", "isRefreshing", "postDetail", "getPostDetail", "uiState", "getUiState", "clearError", "", "clearPostDetail", "filterByCategory", "categoryName", "filterByTag", "tagName", "loadCachedPostsFirst", "loadMorePosts", "loadPostDetail", "postName", "loadPostDetailFromServer", "showRefreshIndicator", "loadPosts", "refresh", "keyword", "searchType", "Lcom/halo/blog/data/model/SearchType;", "loadPostsFromServer", "searchPosts", "app_debug"})
public final class PostViewModel extends androidx.lifecycle.ViewModel {
    private final com.halo.blog.data.repository.HaloRepository repository = null;
    private final com.halo.blog.utils.PreferenceManager preferenceManager = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.halo.blog.ui.viewmodel.PostUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.halo.blog.ui.viewmodel.PostUiState> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.halo.blog.data.model.PostDetail> _postDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.halo.blog.data.model.PostDetail> postDetail = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isDetailRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDetailRefreshing = null;
    private int currentPage = 0;
    private boolean isLastPage = false;
    private java.lang.String currentCategory;
    private java.lang.String currentTag;
    private java.lang.String currentKeyword;
    
    @javax.inject.Inject()
    public PostViewModel(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.repository.HaloRepository repository, @org.jetbrains.annotations.NotNull()
    com.halo.blog.utils.PreferenceManager preferenceManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.halo.blog.ui.viewmodel.PostUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.halo.blog.data.model.PostDetail> getPostDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isDetailRefreshing() {
        return null;
    }
    
    /**
     * 首先加载缓存数据，然后在后台刷新
     */
    private final void loadCachedPostsFirst() {
    }
    
    /**
     * 从服务器加载文章数据
     */
    private final void loadPostsFromServer(boolean showRefreshIndicator, boolean refresh, java.lang.String categoryName, java.lang.String tagName, java.lang.String keyword, com.halo.blog.data.model.SearchType searchType) {
    }
    
    /**
     * 公开的加载文章方法
     */
    public final void loadPosts(boolean refresh, @org.jetbrains.annotations.Nullable()
    java.lang.String categoryName, @org.jetbrains.annotations.Nullable()
    java.lang.String tagName, @org.jetbrains.annotations.Nullable()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.SearchType searchType) {
    }
    
    public final void loadMorePosts() {
    }
    
    public final void loadPostDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String postName) {
    }
    
    private final void loadPostDetailFromServer(java.lang.String postName, boolean showRefreshIndicator) {
    }
    
    public final void searchPosts(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.SearchType searchType) {
    }
    
    public final void filterByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryName) {
    }
    
    public final void filterByTag(@org.jetbrains.annotations.NotNull()
    java.lang.String tagName) {
    }
    
    public final void clearError() {
    }
    
    public final void clearPostDetail() {
    }
}