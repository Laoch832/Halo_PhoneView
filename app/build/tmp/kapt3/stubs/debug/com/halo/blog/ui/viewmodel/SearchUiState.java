package com.halo.blog.ui.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/halo/blog/ui/viewmodel/SearchUiState;", "", "searchResults", "", "Lcom/halo/blog/data/model/SearchResultItem;", "keyword", "", "total", "", "processingTime", "(Ljava/util/List;Ljava/lang/String;II)V", "getKeyword", "()Ljava/lang/String;", "getProcessingTime", "()I", "getSearchResults", "()Ljava/util/List;", "getTotal", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class SearchUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.halo.blog.data.model.SearchResultItem> searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String keyword = null;
    private final int total = 0;
    private final int processingTime = 0;
    
    @org.jetbrains.annotations.NotNull()
    public final com.halo.blog.ui.viewmodel.SearchUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.halo.blog.data.model.SearchResultItem> searchResults, @org.jetbrains.annotations.NotNull()
    java.lang.String keyword, int total, int processingTime) {
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
    
    public SearchUiState() {
        super();
    }
    
    public SearchUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.halo.blog.data.model.SearchResultItem> searchResults, @org.jetbrains.annotations.NotNull()
    java.lang.String keyword, int total, int processingTime) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.halo.blog.data.model.SearchResultItem> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.halo.blog.data.model.SearchResultItem> getSearchResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getKeyword() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getTotal() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getProcessingTime() {
        return 0;
    }
}