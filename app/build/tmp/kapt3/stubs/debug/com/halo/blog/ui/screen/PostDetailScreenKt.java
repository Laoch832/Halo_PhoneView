package com.halo.blog.ui.screen;

import java.lang.System;

@kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001ad\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u0012"}, d2 = {"PostDetailContent", "", "postDetail", "Lcom/halo/blog/data/model/PostDetail;", "postName", "", "onCategoryClick", "Lkotlin/Function1;", "onTagClick", "commentViewModel", "Lcom/halo/blog/ui/viewmodel/CommentViewModel;", "modifier", "Landroidx/compose/ui/Modifier;", "PostDetailScreen", "onBackClick", "Lkotlin/Function0;", "viewModel", "Lcom/halo/blog/ui/viewmodel/PostViewModel;", "app_debug"})
public final class PostDetailScreenKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void PostDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String postName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCategoryClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTagClick, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    com.halo.blog.ui.viewmodel.PostViewModel viewModel, @org.jetbrains.annotations.NotNull()
    com.halo.blog.ui.viewmodel.CommentViewModel commentViewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PostDetailContent(@org.jetbrains.annotations.NotNull()
    com.halo.blog.data.model.PostDetail postDetail, @org.jetbrains.annotations.NotNull()
    java.lang.String postName, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onCategoryClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onTagClick, @org.jetbrains.annotations.NotNull()
    com.halo.blog.ui.viewmodel.CommentViewModel commentViewModel, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}