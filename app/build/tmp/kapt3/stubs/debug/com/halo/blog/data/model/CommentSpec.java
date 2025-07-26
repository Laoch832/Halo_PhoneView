package com.halo.blog.data.model;

import java.lang.System;

/**
 * 评论规格
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\b\u0087\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u000eH\u00c6\u0003J\t\u0010+\u001a\u00020\u000eH\u00c6\u0003J\t\u0010,\u001a\u00020\u000eH\u00c6\u0003J\t\u0010-\u001a\u00020\u0013H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0006H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\fH\u00c6\u0003J\t\u00106\u001a\u00020\u000eH\u00c6\u0003J\u0099\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u00108\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010:\u001a\u00020\fH\u00d6\u0001J\t\u0010;\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001a\u00a8\u0006<"}, d2 = {"Lcom/halo/blog/data/model/CommentSpec;", "", "raw", "", "content", "owner", "Lcom/halo/blog/data/model/CommentSpecOwner;", "userAgent", "ipAddress", "approvedTime", "creationTime", "priority", "", "top", "", "allowNotification", "approved", "hidden", "subjectRef", "Lcom/halo/blog/data/model/CommentSubjectRef;", "lastReadTime", "(Ljava/lang/String;Ljava/lang/String;Lcom/halo/blog/data/model/CommentSpecOwner;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZZZLcom/halo/blog/data/model/CommentSubjectRef;Ljava/lang/String;)V", "getAllowNotification", "()Z", "getApproved", "getApprovedTime", "()Ljava/lang/String;", "getContent", "getCreationTime", "getHidden", "getIpAddress", "getLastReadTime", "getOwner", "()Lcom/halo/blog/data/model/CommentSpecOwner;", "getPriority", "()I", "getRaw", "getSubjectRef", "()Lcom/halo/blog/data/model/CommentSubjectRef;", "getTop", "getUserAgent", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class CommentSpec {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String raw = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    @org.jetbrains.annotations.NotNull()
    private final com.halo.blog.data.model.CommentSpecOwner owner = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userAgent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String ipAddress = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String approvedTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String creationTime = null;
    private final int priority = 0;
    private final boolean top = false;
    private final boolean allowNotification = false;
    private final boolean approved = false;
    private final boolean hidden = false;
    @org.jetbrains.annotations.NotNull()
    private final com.halo.blog.data.model.CommentSubjectRef subjectRef = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String lastReadTime = null;
    
    /**
     * 评论规格
     */
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.CommentSpec copy(@org.jetbrains.annotations.NotNull()
    java.lang.String raw, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.CommentSpecOwner owner, @org.jetbrains.annotations.NotNull()
    java.lang.String userAgent, @org.jetbrains.annotations.NotNull()
    java.lang.String ipAddress, @org.jetbrains.annotations.Nullable()
    java.lang.String approvedTime, @org.jetbrains.annotations.NotNull()
    java.lang.String creationTime, int priority, boolean top, boolean allowNotification, boolean approved, boolean hidden, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.CommentSubjectRef subjectRef, @org.jetbrains.annotations.Nullable()
    java.lang.String lastReadTime) {
        return null;
    }
    
    /**
     * 评论规格
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * 评论规格
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 评论规格
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public CommentSpec(@org.jetbrains.annotations.NotNull()
    java.lang.String raw, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.CommentSpecOwner owner, @org.jetbrains.annotations.NotNull()
    java.lang.String userAgent, @org.jetbrains.annotations.NotNull()
    java.lang.String ipAddress, @org.jetbrains.annotations.Nullable()
    java.lang.String approvedTime, @org.jetbrains.annotations.NotNull()
    java.lang.String creationTime, int priority, boolean top, boolean allowNotification, boolean approved, boolean hidden, @org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.CommentSubjectRef subjectRef, @org.jetbrains.annotations.Nullable()
    java.lang.String lastReadTime) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.CommentSpecOwner component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.CommentSpecOwner getOwner() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserAgent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIpAddress() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getApprovedTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreationTime() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getPriority() {
        return 0;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getTop() {
        return false;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean getAllowNotification() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean getApproved() {
        return false;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean getHidden() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.CommentSubjectRef component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.CommentSubjectRef getSubjectRef() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastReadTime() {
        return null;
    }
}