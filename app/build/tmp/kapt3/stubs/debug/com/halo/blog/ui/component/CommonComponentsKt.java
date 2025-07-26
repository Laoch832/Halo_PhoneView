package com.halo.blog.ui.component;

import java.lang.System;

@kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a$\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001a(\u0010\r\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u001a\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u001a\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a0\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0014H\u0007\u001a\u0012\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0012\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a(\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a*\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\nH\u0002\u00a8\u0006\u001f"}, d2 = {"CategoryChip", "", "category", "Lcom/halo/blog/data/model/CategoryItem;", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "EmptyState", "message", "", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ErrorMessage", "onRetry", "HtmlContent", "html", "HtmlTextContent", "HtmlTextContentWithImages", "onImageClick", "Lkotlin/Function1;", "LoadingIndicator", "RefreshIndicator", "TagChip", "tag", "Lcom/halo/blog/data/model/TagItem;", "extractAudioFromHtml", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "app_debug"})
public final class CommonComponentsKt {
    
    @androidx.compose.runtime.Composable()
    public static final void LoadingIndicator(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RefreshIndicator(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ErrorMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onRetry, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CategoryChip(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.CategoryItem category, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TagChip(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.TagItem tag, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HtmlContent(@org.jetbrains.annotations.NotNull()
    java.lang.String html, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HtmlTextContentWithImages(@org.jetbrains.annotations.NotNull()
    java.lang.String html, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onImageClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HtmlTextContent(@org.jetbrains.annotations.NotNull()
    java.lang.String html, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    private static final kotlin.Pair<java.lang.String, java.util.List<java.lang.String>> extractAudioFromHtml(android.content.Context context, java.lang.String html) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EmptyState(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.graphics.vector.ImageVector icon) {
    }
}