package com.halo.blog.data.model

import com.google.gson.annotations.SerializedName

// 搜索请求参数
data class SearchOption(
    val keyword: String,
    val limit: Int? = null,
    val includeTypes: List<String>? = null,
    val includeCategoryNames: List<String>? = null,
    val includeTagNames: List<String>? = null,
    val includeOwnerNames: List<String>? = null,
    val highlightPreTag: String? = null,
    val highlightPostTag: String? = null,
    val annotations: Map<String, String>? = null
)

// 搜索响应结果
data class SearchResult(
    val keyword: String,
    val limit: Int,
    val total: Int,
    val processingTimeMillis: Int,
    val hits: List<HaloDocument>
)

// 搜索结果中的文档
data class HaloDocument(
    val id: String,
    val metadataName: String,
    val title: String,
    val description: String?,
    val content: String?,
    val categories: List<String>?,
    val tags: List<String>?,
    val published: Boolean,
    val recycled: Boolean,
    val exposed: Boolean,
    val ownerName: String?,
    val creationTimestamp: String,
    val updateTimestamp: String,
    val permalink: String,
    val type: String
)

// 用于显示的搜索结果项
data class SearchResultItem(
    val id: String,
    val title: String,
    val description: String?,
    val content: String?,
    val permalink: String,
    val creationTimestamp: String,
    val categories: List<String>?,
    val tags: List<String>?
) {
    companion object {
        fun fromHaloDocument(document: HaloDocument): SearchResultItem {
            return SearchResultItem(
                id = document.id,
                title = document.title,
                description = document.description,
                content = document.content,
                permalink = document.permalink,
                creationTimestamp = document.creationTimestamp,
                categories = document.categories,
                tags = document.tags
            )
        }
    }
}