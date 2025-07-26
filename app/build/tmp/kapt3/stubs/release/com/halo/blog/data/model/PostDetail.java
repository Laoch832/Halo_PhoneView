package com.halo.blog.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fH\u00c6\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020&H\u00d6\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u00a8\u0006\'"}, d2 = {"Lcom/halo/blog/data/model/PostDetail;", "", "post", "Lcom/halo/blog/data/model/Post;", "content", "Lcom/halo/blog/data/model/PostContent;", "categories", "", "Lcom/halo/blog/data/model/CategoryItem;", "tags", "Lcom/halo/blog/data/model/TagItem;", "prevPost", "Lcom/halo/blog/data/model/PostItem;", "nextPost", "(Lcom/halo/blog/data/model/Post;Lcom/halo/blog/data/model/PostContent;Ljava/util/List;Ljava/util/List;Lcom/halo/blog/data/model/PostItem;Lcom/halo/blog/data/model/PostItem;)V", "getCategories", "()Ljava/util/List;", "getContent", "()Lcom/halo/blog/data/model/PostContent;", "getNextPost", "()Lcom/halo/blog/data/model/PostItem;", "getPost", "()Lcom/halo/blog/data/model/Post;", "getPrevPost", "getTags", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"})
public final class PostDetail {
    @org.jetbrains.annotations.NotNull()
    private final com.halo.blog.data.model.Post post = null;
    @org.jetbrains.annotations.Nullable()
    private final com.halo.blog.data.model.PostContent content = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.halo.blog.data.model.CategoryItem> categories = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.halo.blog.data.model.TagItem> tags = null;
    @org.jetbrains.annotations.Nullable()
    private final com.halo.blog.data.model.PostItem prevPost = null;
    @org.jetbrains.annotations.Nullable()
    private final com.halo.blog.data.model.PostItem nextPost = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.PostDetail copy(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.Post post, @org.jetbrains.annotations.Nullable()
    com.halo.blog.data.model.PostContent content, @org.jetbrains.annotations.Nullable()
    java.util.List<com.halo.blog.data.model.CategoryItem> categories, @org.jetbrains.annotations.Nullable()
    java.util.List<com.halo.blog.data.model.TagItem> tags, @org.jetbrains.annotations.Nullable()
    com.halo.blog.data.model.PostItem prevPost, @org.jetbrains.annotations.Nullable()
    com.halo.blog.data.model.PostItem nextPost) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public PostDetail(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.Post post, @org.jetbrains.annotations.Nullable()
    com.halo.blog.data.model.PostContent content, @org.jetbrains.annotations.Nullable()
    java.util.List<com.halo.blog.data.model.CategoryItem> categories, @org.jetbrains.annotations.Nullable()
    java.util.List<com.halo.blog.data.model.TagItem> tags, @org.jetbrains.annotations.Nullable()
    com.halo.blog.data.model.PostItem prevPost, @org.jetbrains.annotations.Nullable()
    com.halo.blog.data.model.PostItem nextPost) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.Post component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.Post getPost() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostContent component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostContent getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.halo.blog.data.model.CategoryItem> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.halo.blog.data.model.CategoryItem> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.halo.blog.data.model.TagItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.halo.blog.data.model.TagItem> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostItem component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostItem getPrevPost() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostItem component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostItem getNextPost() {
        return null;
    }
}