package com.halo.blog.data.model

import com.google.gson.annotations.SerializedName

data class PostResponse(
    val items: List<Post>,
    val page: Int,
    val size: Int,
    val total: Long,
    val totalPages: Int,
    val first: Boolean,
    val last: Boolean,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)

data class Post(
    val metadata: PostMetadata,
    val spec: PostSpec,
    val status: PostStatus?,
    val content: PostContentData?
)

data class PostMetadata(
    val name: String,
    val labels: Map<String, String>?,
    val annotations: Map<String, String>?,
    val creationTimestamp: String,
    val version: Long?
)

data class PostSpec(
    val title: String,
    val slug: String,
    val template: String?,
    val cover: String?,
    val deleted: Boolean,
    val publish: Boolean,
    val publishTime: String?,
    val pinned: Boolean,
    val allowComment: Boolean,
    val visible: String,
    val priority: Int,
    val excerpt: PostExcerpt?,
    val categories: List<String>?,
    val tags: List<String>?,
    val htmlMetas: List<HtmlMeta>?
)

data class PostStatus(
    val phase: String,
    val conditions: List<Condition>?,
    val permalink: String?,
    val excerpt: String?,
    val inProgress: Boolean,
    val commentsCount: Int,
    val observedVersion: Long?
)

data class PostExcerpt(
    val autoGenerate: Boolean,
    val raw: String?
)

data class HtmlMeta(
    val name: String,
    val content: String
)

data class Condition(
    val type: String,
    val status: String,
    val reason: String?,
    val message: String?,
    val lastTransitionTime: String
)

// 文章内容数据
data class PostContentData(
    val raw: String,
    val content: String
)

// 用于显示的简化文章模型
data class PostItem(
    val name: String,
    val title: String,
    val slug: String,
    val cover: String?,
    val excerpt: String?,
    val publishTime: String?,
    val permalink: String?,
    val categories: List<String>?,
    val tags: List<String>?,
    val commentsCount: Int,
    val pinned: Boolean
) {
    companion object {
        fun fromPost(post: Post): PostItem {
            return PostItem(
                name = post.metadata.name,
                title = post.spec.title,
                slug = post.spec.slug,
                cover = post.spec.cover,
                excerpt = post.status?.excerpt ?: post.spec.excerpt?.raw,
                publishTime = post.spec.publishTime,
                permalink = post.status?.permalink,
                categories = post.spec.categories,
                tags = post.spec.tags,
                commentsCount = post.status?.commentsCount ?: 0,
                pinned = post.spec.pinned
            )
        }
    }
}