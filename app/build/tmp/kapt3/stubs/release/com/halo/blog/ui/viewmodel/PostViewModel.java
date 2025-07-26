package com.halo.blog.ui.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u001eJ\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0007J>\u0010\'\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010*\u001a\u00020+J\u0018\u0010,\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00072\b\b\u0002\u0010*\u001a\u00020+R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016\u00a8\u0006-"}, d2 = {"Lcom/halo/blog/ui/viewmodel/PostViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/halo/blog/data/repository/HaloRepository;", "(Lcom/halo/blog/data/repository/HaloRepository;)V", "_error", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isLoading", "", "_postDetail", "Lcom/halo/blog/data/model/PostDetail;", "_uiState", "Lcom/halo/blog/ui/viewmodel/PostUiState;", "currentCategory", "currentKeyword", "currentPage", "", "currentTag", "error", "Lkotlinx/coroutines/flow/StateFlow;", "getError", "()Lkotlinx/coroutines/flow/StateFlow;", "isLastPage", "isLoading", "postDetail", "getPostDetail", "uiState", "getUiState", "clearError", "", "clearPostDetail", "filterByCategory", "categoryName", "filterByTag", "tagName", "loadMorePosts", "loadPostDetail", "postName", "loadPosts", "refresh", "keyword", "searchType", "Lcom/halo/blog/data/model/SearchType;", "searchPosts", "app_release"})
public final class PostViewModel extends androidx.lifecycle.ViewModel {
    private final com.halo.blog.data.repository.HaloRepository repository = null;
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
    private int currentPage = 0;
    private boolean isLastPage = false;
    private java.lang.String currentCategory;
    private java.lang.String currentTag;
    private java.lang.String currentKeyword;
    
    @javax.inject.Inject()
    public PostViewModel(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.repository.HaloRepository repository) {
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