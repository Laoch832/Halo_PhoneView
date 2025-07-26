package com.halo.blog.data.model

data class CategoryResponse(
    val items: List<Category>,
    val page: Int,
    val size: Int,
    val total: Long,
    val totalPages: Int,
    val first: Boolean,
    val last: Boolean,
    val hasNext: Boolean,
    val hasPrevious: Boolean
)

data class Category(
    val metadata: CategoryMetadata,
    val spec: CategorySpec,
    val status: CategoryStatus?
)

data class CategoryMetadata(
    val name: String,
    val labels: Map<String, String>?,
    val annotations: Map<String, String>?,
    val creationTimestamp: String,
    val version: Long?
)

data class CategorySpec(
    val displayName: String,
    val slug: String,
    val description: String?,
    val cover: String?,
    val template: String?,
    val priority: Int,
    val children: List<String>?
)

data class CategoryStatus(
    val permalink: String?,
    val postCount: Int,
    val visiblePostCount: Int,
    val observedVersion: Long?
)

// 用于显示的简化分类模型
data class CategoryItem(
    val name: String,
    val displayName: String,
    val slug: String,
    val description: String?,
    val cover: String?,
    val postCount: Int,
    val permalink: String?
) {
    companion object {
        fun fromCategory(category: Category): CategoryItem {
            return CategoryItem(
                name = category.metadata.name,
                displayName = category.spec.displayName,
                slug = category.spec.slug,
                description = category.spec.description,
                cover = category.spec.cover,
                postCount = category.status?.postCount ?: 0,
                permalink = category.status?.permalink
            )
        }
    }
}