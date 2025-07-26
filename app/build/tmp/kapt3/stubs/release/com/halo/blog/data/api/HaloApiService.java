package com.halo.blog.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\r\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\r\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\r\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJM\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J?\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0016\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J?\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0016\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\r\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ5\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ?\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J?\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J?\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0016\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/halo/blog/data/api/HaloApiService;", "", "getCategories", "Lretrofit2/Response;", "Lcom/halo/blog/data/model/CategoryResponse;", "page", "", "size", "sort", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategory", "Lcom/halo/blog/data/model/Category;", "name", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPost", "Lcom/halo/blog/data/model/Post;", "getPostContent", "Lcom/halo/blog/data/model/PostContent;", "getPosts", "Lcom/halo/blog/data/model/PostResponse;", "labelSelector", "fieldSelector", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostsByCategory", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostsByTag", "getTag", "Lcom/halo/blog/data/model/Tag;", "getTags", "Lcom/halo/blog/data/model/TagResponse;", "searchPosts", "keyword", "searchPostsByContent", "searchPostsByTitle", "app_release"})
public abstract interface HaloApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/posts")
    public abstract java.lang.Object getPosts(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort")
    java.lang.String sort, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "labelSelector")
    java.lang.String labelSelector, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "fieldSelector")
    java.lang.String fieldSelector, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.PostResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/posts/{name}")
    public abstract java.lang.Object getPost(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "name")
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.Post>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/posts/{name}/content")
    public abstract java.lang.Object getPostContent(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "name")
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.PostContent>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/categories")
    public abstract java.lang.Object getCategories(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort")
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.CategoryResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/categories/{name}")
    public abstract java.lang.Object getCategory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "name")
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.Category>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/tags")
    public abstract java.lang.Object getTags(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort")
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.TagResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/tags/{name}")
    public abstract java.lang.Object getTag(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "name")
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.Tag>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/posts")
    public abstract java.lang.Object getPostsByCategory(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort")
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "fieldSelector")
    java.lang.String fieldSelector, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.PostResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/posts")
    public abstract java.lang.Object getPostsByTag(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort")
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "fieldSelector")
    java.lang.String fieldSelector, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.PostResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/posts")
    public abstract java.lang.Object searchPosts(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort")
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "keyword")
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.PostResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/posts")
    public abstract java.lang.Object searchPostsByTitle(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort")
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "fieldSelector")
    java.lang.String fieldSelector, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.PostResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.content.halo.run/v1alpha1/posts")
    public abstract java.lang.Object searchPostsByContent(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "sort")
    java.lang.String sort, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "keyword")
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.PostResponse>> continuation);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}