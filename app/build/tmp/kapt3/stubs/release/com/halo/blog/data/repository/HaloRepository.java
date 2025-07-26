package com.halo.blog.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006\u00f8\u0001\u0000J\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010\f\u001a\u00020\r\u00f8\u0001\u0000JW\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u00f8\u0001\u0000J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\b0\u00070\u0006\u00f8\u0001\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/halo/blog/data/repository/HaloRepository;", "", "apiService", "Lcom/halo/blog/data/api/HaloApiService;", "(Lcom/halo/blog/data/api/HaloApiService;)V", "getCategories", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "", "Lcom/halo/blog/data/model/CategoryItem;", "getPostDetail", "Lcom/halo/blog/data/model/PostDetail;", "name", "", "getPosts", "Lcom/halo/blog/data/model/PostResponse;", "page", "", "size", "categoryName", "tagName", "keyword", "searchType", "Lcom/halo/blog/data/model/SearchType;", "getTags", "Lcom/halo/blog/data/model/TagItem;", "app_release"})
@javax.inject.Singleton()
public final class HaloRepository {
    private final com.halo.blog.data.api.HaloApiService apiService = null;
    
    @javax.inject.Inject()
    public HaloRepository(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.api.HaloApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.halo.blog.data.model.PostResponse>> getPosts(int page, int size, @org.jetbrains.annotations.Nullable()
    java.lang.String categoryName, @org.jetbrains.annotations.Nullable()
    java.lang.String tagName, @org.jetbrains.annotations.Nullable()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.SearchType searchType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.halo.blog.data.model.PostDetail>> getPostDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.halo.blog.data.model.CategoryItem>>> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<java.util.List<com.halo.blog.data.model.TagItem>>> getTags() {
        return null;
    }
}