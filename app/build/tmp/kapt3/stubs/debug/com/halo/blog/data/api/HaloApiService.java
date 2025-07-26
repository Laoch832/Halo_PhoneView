package com.halo.blog.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014Jg\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00062\b\b\u0003\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u001a\u001a\u00020\u00062\b\b\u0003\u0010\u001b\u001a\u00020\u001c2\b\b\u0003\u0010\u001d\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J!\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014JM\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u00062\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\'J?\u0010(\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J?\u0010*\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J!\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J5\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J!\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00032\b\b\u0001\u00101\u001a\u000202H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00103J?\u00104\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u00105\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J?\u00106\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u00105\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J?\u00107\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0003\u0010\u000e\u001a\u00020\r2\b\b\u0003\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/halo/blog/data/api/HaloApiService;", "", "createComment", "Lretrofit2/Response;", "Lcom/halo/blog/data/model/Comment;", "authorization", "", "commentRequest", "Lcom/halo/blog/data/model/CommentRequest;", "(Ljava/lang/String;Lcom/halo/blog/data/model/CommentRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategories", "Lcom/halo/blog/data/model/CategoryResponse;", "page", "", "size", "sort", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCategory", "Lcom/halo/blog/data/model/Category;", "name", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getComments", "Lcom/halo/blog/data/model/CommentResponse;", "group", "kind", "postName", "version", "withReplies", "", "replySize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPost", "Lcom/halo/blog/data/model/Post;", "getPostContent", "Lcom/halo/blog/data/model/PostContent;", "getPosts", "Lcom/halo/blog/data/model/PostResponse;", "labelSelector", "fieldSelector", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostsByCategory", "(IILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPostsByTag", "getTag", "Lcom/halo/blog/data/model/Tag;", "getTags", "Lcom/halo/blog/data/model/TagResponse;", "searchContent", "Lcom/halo/blog/data/model/SearchResult;", "searchOption", "Lcom/halo/blog/data/model/SearchOption;", "(Lcom/halo/blog/data/model/SearchOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchPosts", "keyword", "searchPostsByContent", "searchPostsByTitle", "app_debug"})
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
    @retrofit2.http.POST(value = "apis/api.halo.run/v1alpha1/indices/-/search")
    public abstract java.lang.Object searchContent(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.halo.blog.data.model.SearchOption searchOption, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.SearchResult>> continuation);
    
    /**
     * 获取文章评论
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "apis/api.halo.run/v1alpha1/comments")
    public abstract java.lang.Object getComments(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "group")
    java.lang.String group, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "kind")
    java.lang.String kind, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "name")
    java.lang.String postName, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "version")
    java.lang.String version, @retrofit2.http.Query(value = "withReplies")
    boolean withReplies, @retrofit2.http.Query(value = "replySize")
    int replySize, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.CommentResponse>> continuation);
    
    /**
     * 发表评论
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "apis/api.halo.run/v1alpha1/comments")
    public abstract java.lang.Object createComment(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String authorization, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.halo.blog.data.model.CommentRequest commentRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.halo.blog.data.model.Comment>> continuation);
    
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