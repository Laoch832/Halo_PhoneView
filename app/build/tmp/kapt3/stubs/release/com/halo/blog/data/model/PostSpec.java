package com.halo.blog.data.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u000fH\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u00c6\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H\u00c6\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\bH\u00c6\u0003J\t\u00107\u001a\u00020\bH\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\bH\u00c6\u0003J\t\u0010:\u001a\u00020\bH\u00c6\u0003J\u00bf\u0001\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013H\u00c6\u0001J\u0013\u0010<\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010>\u001a\u00020\u000fH\u00d6\u0001J\t\u0010?\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001d\u00a8\u0006@"}, d2 = {"Lcom/halo/blog/data/model/PostSpec;", "", "title", "", "slug", "template", "cover", "deleted", "", "publish", "publishTime", "pinned", "allowComment", "visible", "priority", "", "excerpt", "Lcom/halo/blog/data/model/PostExcerpt;", "categories", "", "tags", "htmlMetas", "Lcom/halo/blog/data/model/HtmlMeta;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;ZZLjava/lang/String;ILcom/halo/blog/data/model/PostExcerpt;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAllowComment", "()Z", "getCategories", "()Ljava/util/List;", "getCover", "()Ljava/lang/String;", "getDeleted", "getExcerpt", "()Lcom/halo/blog/data/model/PostExcerpt;", "getHtmlMetas", "getPinned", "getPriority", "()I", "getPublish", "getPublishTime", "getSlug", "getTags", "getTemplate", "getTitle", "getVisible", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_release"})
public final class PostSpec {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String slug = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String template = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String cover = null;
    private final boolean deleted = false;
    private final boolean publish = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String publishTime = null;
    private final boolean pinned = false;
    private final boolean allowComment = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String visible = null;
    private final int priority = 0;
    @org.jetbrains.annotations.Nullable()
    private final com.halo.blog.data.model.PostExcerpt excerpt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> categories = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> tags = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.halo.blog.data.model.HtmlMeta> htmlMetas = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.data.model.PostSpec copy(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.Nullable()
    java.lang.String template, @org.jetbrains.annotations.Nullable()
    java.lang.String cover, boolean deleted, boolean publish, @org.jetbrains.annotations.Nullable()
    java.lang.String publishTime, boolean pinned, boolean allowComment, @org.jetbrains.annotations.NotNull()
    java.lang.String visible, int priority, @org.jetbrains.annotations.Nullable()
    com.halo.blog.data.model.PostExcerpt excerpt, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.Nullable()
    java.util.List<com.halo.blog.data.model.HtmlMeta> htmlMetas) {
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
    
    public PostSpec(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.Nullable()
    java.lang.String template, @org.jetbrains.annotations.Nullable()
    java.lang.String cover, boolean deleted, boolean publish, @org.jetbrains.annotations.Nullable()
    java.lang.String publishTime, boolean pinned, boolean allowComment, @org.jetbrains.annotations.NotNull()
    java.lang.String visible, int priority, @org.jetbrains.annotations.Nullable()
    com.halo.blog.data.model.PostExcerpt excerpt, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> categories, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.Nullable()
    java.util.List<com.halo.blog.data.model.HtmlMeta> htmlMetas) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSlug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTemplate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCover() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getDeleted() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getPublish() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPublishTime() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getPinned() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean getAllowComment() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getVisible() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getPriority() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostExcerpt component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.halo.blog.data.model.PostExcerpt getExcerpt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.halo.blog.data.model.HtmlMeta> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.halo.blog.data.model.HtmlMeta> getHtmlMetas() {
        return null;
    }
}