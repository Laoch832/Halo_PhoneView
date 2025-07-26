package com.halo.blog.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u00f8\u0001\u0000J\u001b\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00070\u0006\u00f8\u0001\u0000J1\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u00062\u0006\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00f8\u0001\u0000J\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00070\u00062\u0006\u0010\u0017\u001a\u00020\n\u00f8\u0001\u0000JW\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00070\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u00f8\u0001\u0000J\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00070\u00062\u0006\u0010!\u001a\u00020\n\u00f8\u0001\u0000J\u001b\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u000e0\u00070\u0006\u00f8\u0001\u0000Jq\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00070\u00062\u0006\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010%\u001a\u00020\u00132\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0010\b\u0002\u0010\'\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\b\b\u0002\u0010)\u001a\u00020\n2\b\b\u0002\u0010*\u001a\u00020\n\u00f8\u0001\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/halo/blog/data/repository/HaloRepository;", "", "apiService", "Lcom/halo/blog/data/api/HaloApiService;", "(Lcom/halo/blog/data/api/HaloApiService;)V", "createComment", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "Lcom/halo/blog/data/model/Comment;", "apiKey", "", "commentContent", "postName", "getCategories", "", "Lcom/halo/blog/data/model/CategoryItem;", "getComments", "Lcom/halo/blog/data/model/CommentResponse;", "page", "", "size", "getPostDetail", "Lcom/halo/blog/data/model/PostDetail;", "name", "getPosts", "Lcom/halo/blog/data/model/PostResponse;", "categoryName", "tagName", "keyword", "searchType", "Lcom/halo/blog/data/model/SearchType;", "getTagInfo", "Lcom/halo/blog/data/model/TagItem;", "tagSlug", "getTags", "searchContent", "Lcom/halo/blog/data/model/SearchResult;", "limit", "includeTypes", "includeCategoryNames", "includeTagNames", "highlightPreTag", "highlightPostTag", "app_debug"})
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.halo.blog.data.model.TagItem>> getTagInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String tagSlug) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.halo.blog.data.model.SearchResult>> searchContent(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, int limit, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> includeTypes, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> includeCategoryNames, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> includeTagNames, @org.jetbrains.annotations.NotNull()
    java.lang.String highlightPreTag, @org.jetbrains.annotations.NotNull()
    java.lang.String highlightPostTag) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.halo.blog.data.model.CommentResponse>> getComments(@org.jetbrains.annotations.NotNull()
    java.lang.String postName, int page, int size) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<com.halo.blog.data.model.Comment>> createComment(@org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    java.lang.String commentContent, @org.jetbrains.annotations.NotNull()
    java.lang.String postName) {
        return null;
    }
}