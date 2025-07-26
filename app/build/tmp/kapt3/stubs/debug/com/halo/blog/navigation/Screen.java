package com.halo.blog.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0007\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/halo/blog/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Category", "Home", "PostDetail", "Search", "ServerSelection", "Settings", "Tag", "Lcom/halo/blog/navigation/Screen$Category;", "Lcom/halo/blog/navigation/Screen$Home;", "Lcom/halo/blog/navigation/Screen$PostDetail;", "Lcom/halo/blog/navigation/Screen$Search;", "Lcom/halo/blog/navigation/Screen$ServerSelection;", "Lcom/halo/blog/navigation/Screen$Settings;", "Lcom/halo/blog/navigation/Screen$Tag;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/halo/blog/navigation/Screen$ServerSelection;", "Lcom/halo/blog/navigation/Screen;", "()V", "app_debug"})
    public static final class ServerSelection extends com.halo.blog.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.halo.blog.navigation.Screen.ServerSelection INSTANCE = null;
        
        private ServerSelection() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/halo/blog/navigation/Screen$Home;", "Lcom/halo/blog/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.halo.blog.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.halo.blog.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/halo/blog/navigation/Screen$PostDetail;", "Lcom/halo/blog/navigation/Screen;", "()V", "createRoute", "", "postName", "app_debug"})
    public static final class PostDetail extends com.halo.blog.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.halo.blog.navigation.Screen.PostDetail INSTANCE = null;
        
        private PostDetail() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String postName) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/halo/blog/navigation/Screen$Search;", "Lcom/halo/blog/navigation/Screen;", "()V", "app_debug"})
    public static final class Search extends com.halo.blog.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.halo.blog.navigation.Screen.Search INSTANCE = null;
        
        private Search() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/halo/blog/navigation/Screen$Category;", "Lcom/halo/blog/navigation/Screen;", "()V", "createRoute", "", "categoryName", "app_debug"})
    public static final class Category extends com.halo.blog.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.halo.blog.navigation.Screen.Category INSTANCE = null;
        
        private Category() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String categoryName) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/halo/blog/navigation/Screen$Tag;", "Lcom/halo/blog/navigation/Screen;", "()V", "createRoute", "", "tagName", "app_debug"})
    public static final class Tag extends com.halo.blog.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.halo.blog.navigation.Screen.Tag INSTANCE = null;
        
        private Tag() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createRoute(@org.jetbrains.annotations.NotNull()
        java.lang.String tagName) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/halo/blog/navigation/Screen$Settings;", "Lcom/halo/blog/navigation/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.halo.blog.navigation.Screen {
        @org.jetbrains.annotations.NotNull()
        public static final com.halo.blog.navigation.Screen.Settings INSTANCE = null;
        
        private Settings() {
            super(null);
        }
    }
}