package com.halo.blog.data.model

data class PostContent(
    val metadata: PostContentMetadata,
    val spec: PostContentSpec
)

data class PostContentMetadata(
    val name: String,
    val labels: Map<String, String>?,
    val annotations: Map<String, String>?,
    val creationTimestamp: String,
    val version: Long?
)

data class PostContentSpec(
    val raw: String,
    val content: String,
    val rawType: String
)

// 文章详情，包含文章信息和内容
data class PostDetail(
    val post: Post,
    val content: PostContent?,
    val categories: List<CategoryItem>?,
    val tags: List<TagItem>?,
    val prevPost: PostItem?,
    val nextPost: PostItem?
)