package com.halo.blog.ui.viewmodel;

import java.lang.System;

/**
 * 评论UI状态
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0010J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010\u001f\u001a\u00020\nH\u00c6\u0003J\t\u0010 \u001a\u00020\nH\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003Jm\u0010%\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010&\u001a\u00020\u00062\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\nH\u00d6\u0001J\t\u0010)\u001a\u00020\bH\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0018R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014\u00a8\u0006*"}, d2 = {"Lcom/halo/blog/ui/viewmodel/CommentUiState;", "", "comments", "", "Lcom/halo/blog/data/model/CommentItem;", "isLoading", "", "error", "", "total", "", "currentPage", "hasMore", "isSubmitting", "submitError", "submitSuccess", "(Ljava/util/List;ZLjava/lang/String;IIZZLjava/lang/String;Z)V", "getComments", "()Ljava/util/List;", "getCurrentPage", "()I", "getError", "()Ljava/lang/String;", "getHasMore", "()Z", "getSubmitError", "getSubmitSuccess", "getTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class CommentUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.halo.blog.data.model.CommentItem> comments = null;
    private final boolean isLoading = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String error = null;
    private final int total = 0;
    private final int currentPage = 0;
    private final boolean hasMore = false;
    private final boolean isSubmitting = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String submitError = null;
    private final boolean submitSuccess = false;
    
    /**
     * 评论UI状态
     */
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.ui.viewmodel.CommentUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.halo.blog.data.model.CommentItem> comments, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, int total, int currentPage, boolean hasMore, boolean isSubmitting, @org.jetbrains.annotations.Nullable()
    java.lang.String submitError, boolean submitSuccess) {
        return null;
    }
    
    /**
     * 评论UI状态
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    /**
     * 评论UI状态
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 评论UI状态
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public CommentUiState() {
        super();
    }
    
    public CommentUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.halo.blog.data.model.CommentItem> comments, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String error, int total, int currentPage, boolean hasMore, boolean isSubmitting, @org.jetbrains.annotations.Nullable()
    java.lang.String submitError, boolean submitSuccess) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.halo.blog.data.model.CommentItem> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.halo.blog.data.model.CommentItem> getComments() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getError() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getTotal() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getCurrentPage() {
        return 0;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getHasMore() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isSubmitting() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSubmitError() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getSubmitSuccess() {
        return false;
    }
}