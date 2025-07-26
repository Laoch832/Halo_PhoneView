package com.halo.blog.data.model;

import java.lang.System;

/**
 * 发表评论请求
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/halo/blog/data/model/CommentRequest;", "", "raw", "", "content", "allowNotification", "", "subjectRef", "Lcom/halo/blog/data/model/CommentSubjectRef;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/halo/blog/data/model/CommentSubjectRef;)V", "getAllowNotification", "()Z", "getContent", "()Ljava/lang/String;", "getRaw", "getSubjectRef", "()Lcom/halo/blog/data/model/CommentSubjectRef;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class CommentRequest {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String raw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    private final boolean allowNotification = false;
    @org.jetbrains.annotations.NotNull()
    private final com.halo.blog.data.model.CommentSubjectRef subjectRef = null;
    
    /**
     * 发表评论请求
     */
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.CommentRequest copy(@org.jetbrains.annotations.NotNull()
    java.lang.String raw, @org.jetbrains.annotations.NotNull()
    java.lang.String content, boolean allowNotification, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.CommentSubjectRef subjectRef) {
        return null;
    }
    
    /**
     * 发表评论请求
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * 发表评论请求
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 发表评论请求
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public CommentRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String raw, @org.jetbrains.annotations.NotNull()
    java.lang.String content, boolean allowNotification, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.CommentSubjectRef subjectRef) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRaw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getAllowNotification() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.CommentSubjectRef component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.CommentSubjectRef getSubjectRef() {
        return null;
    }
}