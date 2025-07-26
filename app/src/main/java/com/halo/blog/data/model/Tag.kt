package com.halo.blog.data.model

data class TagResponse(
    val items: List<Tag>,
    val page: Int,
    val size: Int,
    val total: Long,
    val totalPages: Int,
    val first: Boolean,
    val last: Boolean,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)

data class Tag(
    val metadata: TagMetadata,
    val spec: TagSpec,
    val status: TagStatus?
)

data class TagMetadata(
    val name: String,
    val labels: Map<String, String>?,
    val annotations: Map<String, String>?,
    val creationTimestamp: String,
    val version: Long?
)

data class TagSpec(
    val displayName: String,
    val slug: String,
    val color: String?,
    val cover: String?
)

data class TagStatus(
    val permalink: String?,
    val postCount: Int,
    val visiblePostCount: Int,
    val observedVersion: Long?
)

// 用于显示的简化标签模型
data class TagItem(
    val name: String,
    val displayName: String,
    val slug: String,
    val color: String?,
    val cover: String?,
    val postCount: Int,
    val permalink: String?
) {
    companion object {
        fun fromTag(tag: Tag): TagItem {
            return TagItem(
                name = tag.metadata.name,
                displayName = tag.spec.displayName,
                slug = tag.spec.slug,
                color = tag.spec.color,
                cover = tag.spec.cover,
                postCount = tag.status?.postCount ?: 0,
                permalink = tag.status?.permalink
            )
        }
    }
}