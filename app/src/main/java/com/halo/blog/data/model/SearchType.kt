package com.halo.blog.data.model

enum class SearchType(val displayName: String) {
    ALL("全部"),
    TITLE("标题"),
    CONTENT("内容"),
    TAG("标签")
}