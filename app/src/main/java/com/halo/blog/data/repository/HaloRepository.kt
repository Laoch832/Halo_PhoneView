package com.halo.blog.data.repository

import com.halo.blog.data.api.HaloApiService
import android.util.Log
import com.halo.blog.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HaloRepository @Inject constructor(
    private val apiService: HaloApiService
) {
    
    // 获取文章列表
    fun getPosts(
        page: Int = 0,
        size: Int = 10,
        categoryName: String? = null,
        tagName: String? = null,
        keyword: String? = null,
        searchType: SearchType = SearchType.ALL
    ): Flow<Result<PostResponse>> = flow {
        try {
            val response = when {
                !categoryName.isNullOrEmpty() -> {
                    apiService.getPostsByCategory(
                        page = page,
                        size = size,
                        fieldSelector = "spec.categories=$categoryName"
                    )
                }
                !tagName.isNullOrEmpty() -> {
                    // 如果tagName看起来像slug（包含连字符），需要先获取对应的内部名称
                    val actualTagName = if (tagName.contains("-")) {
                        // 通过slug查找实际的标签名称
                        val tagsResponse = apiService.getTags()
                        if (tagsResponse.isSuccessful) {
                            tagsResponse.body()?.items?.find { it.spec.slug == tagName }?.metadata?.name ?: tagName
                        } else {
                            tagName
                        }
                    } else {
                        tagName
                    }
                    
                    apiService.getPostsByTag(
                        page = page,
                        size = size,
                        fieldSelector = "spec.tags=$actualTagName"
                    )
                }
                !keyword.isNullOrEmpty() -> {
                    when (searchType) {
                        SearchType.ALL -> {
                            apiService.searchPosts(
                                page = page,
                                size = size,
                                keyword = keyword
                            )
                        }
                        SearchType.TITLE -> {
                            apiService.searchPostsByTitle(
                                page = page,
                                size = size,
                                fieldSelector = "spec.title~$keyword"
                            )
                        }
                        SearchType.CONTENT -> {
                            apiService.searchPostsByContent(
                                page = page,
                                size = size,
                                keyword = keyword
                            )
                        }
                        SearchType.TAG -> {
                            apiService.getPostsByTag(
                                page = page,
                                size = size,
                                fieldSelector = "spec.tags~$keyword"
                            )
                        }
                    }
                }
                else -> {
                    apiService.getPosts(
                        page = page,
                        size = size
                    )
                }
            }
            
            if (response.isSuccessful) {
                response.body()?.let { postResponse ->
                    emit(Result.success(postResponse))
                } ?: emit(Result.failure(Exception("Empty response")))
            } else {
                emit(Result.failure(Exception("HTTP ${response.code()}: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    // 获取文章详情
    fun getPostDetail(name: String): Flow<Result<PostDetail>> = flow {
        try {
            Log.d("HaloRepository", "Fetching post detail for: $name")
            val postResponse = apiService.getPost(name)
            Log.d("HaloRepository", "Post response code: ${postResponse.code()}")
            Log.d("HaloRepository", "Post response successful: ${postResponse.isSuccessful}")
            
            if (postResponse.isSuccessful) {
                val post = postResponse.body()
                if (post != null) {
                    Log.d("HaloRepository", "Post title: ${post.spec.title}")
                    
                    // 文章内容已经包含在post响应中，不需要单独获取
                    Log.d("HaloRepository", "Post content available: ${post.content != null}")
                    val content = post.content?.let {
                        Log.d("HaloRepository", "Content: ${it.content.take(100)}...")
                        PostContent(
                            metadata = PostContentMetadata(
                                name = "${post.metadata.name}-content",
                                labels = null,
                                annotations = null,
                                creationTimestamp = post.metadata.creationTimestamp,
                                version = post.metadata.version
                            ),
                            spec = PostContentSpec(
                                raw = it.raw,
                                content = it.content,
                                rawType = "HTML"
                            )
                        )
                    }
                    
                    Log.d("HaloRepository", "Content created from excerpt: ${content?.spec?.content?.take(100)}...")
                    
                    // 获取分类信息
                    val categories = post.spec.categories?.let { categoryNames ->
                        categoryNames.mapNotNull { categoryName ->
                            try {
                                val categoryResponse = apiService.getCategory(categoryName)
                                if (categoryResponse.isSuccessful) {
                                    categoryResponse.body()?.let { CategoryItem.fromCategory(it) }
                                } else null
                            } catch (e: Exception) {
                                null
                            }
                        }
                    }
                    
                    // 获取标签信息
                    val tags = post.spec.tags?.let { tagNames ->
                        tagNames.mapNotNull { tagName ->
                            try {
                                val tagResponse = apiService.getTag(tagName)
                                if (tagResponse.isSuccessful) {
                                    tagResponse.body()?.let { TagItem.fromTag(it) }
                                } else null
                            } catch (e: Exception) {
                                null
                            }
                        }
                    }
                    
                    val postDetail = PostDetail(
                        post = post,
                        content = content,
                        categories = categories,
                        tags = tags,
                        prevPost = null, // TODO: 实现上一篇/下一篇逻辑
                        nextPost = null
                    )
                    
                    emit(Result.success(postDetail))
                } else {
                    emit(Result.failure(Exception("Post not found")))
                }
            } else {
                emit(Result.failure(Exception("HTTP ${postResponse.code()}: ${postResponse.message()}")))
            }
        } catch (e: Exception) {
            Log.e("HaloRepository", "Error fetching post detail: ${e.message}")
            emit(Result.failure(e))
        }
    }
    
    // 获取分类列表
    fun getCategories(): Flow<Result<List<CategoryItem>>> = flow {
        try {
            val response = apiService.getCategories()
            if (response.isSuccessful) {
                response.body()?.let { categoryResponse ->
                    val categories = categoryResponse.items.map { CategoryItem.fromCategory(it) }
                    emit(Result.success(categories))
                } ?: emit(Result.failure(Exception("Empty response")))
            } else {
                emit(Result.failure(Exception("HTTP ${response.code()}: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    // 获取标签列表
    fun getTags(): Flow<Result<List<TagItem>>> = flow {
        try {
            val response = apiService.getTags()
            if (response.isSuccessful) {
                response.body()?.let { tagResponse ->
                    val tags = tagResponse.items.map { TagItem.fromTag(it) }
                    emit(Result.success(tags))
                } ?: emit(Result.failure(Exception("Empty response")))
            } else {
                emit(Result.failure(Exception("HTTP ${response.code()}: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    // 获取单个标签信息
    fun getTagInfo(tagSlug: String): Flow<Result<TagItem>> = flow {
        try {
            // 首先尝试通过slug获取标签列表，然后找到匹配的标签
            val response = apiService.getTags()
            if (response.isSuccessful) {
                response.body()?.let { tagResponse ->
                    val tag = tagResponse.items.find { it.spec.slug == tagSlug }
                    if (tag != null) {
                        emit(Result.success(TagItem.fromTag(tag)))
                    } else {
                        emit(Result.failure(Exception("Tag not found")))
                    }
                } ?: emit(Result.failure(Exception("Empty response")))
            } else {
                emit(Result.failure(Exception("HTTP ${response.code()}: ${response.message()}")))
            }
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
    
    // 新的搜索方法 - 使用官方搜索API
    fun searchContent(
        keyword: String,
        limit: Int = 10,
        includeTypes: List<String>? = listOf("post.content.halo.run"),
        includeCategoryNames: List<String>? = null,
        includeTagNames: List<String>? = null,
        highlightPreTag: String = "<strong>",
        highlightPostTag: String = "</strong>"
    ): Flow<Result<SearchResult>> = flow {
        try {
            Log.d("HaloRepository", "Searching content with keyword: $keyword")
            
            val searchOption = SearchOption(
                keyword = keyword,
                limit = limit,
                includeTypes = includeTypes,
                includeCategoryNames = includeCategoryNames,
                includeTagNames = includeTagNames,
                highlightPreTag = highlightPreTag,
                highlightPostTag = highlightPostTag
            )
            
            val response = apiService.searchContent(searchOption)
            
            if (response.isSuccessful) {
                response.body()?.let { searchResult ->
                    Log.d("HaloRepository", "Search successful, found ${searchResult.total} results")
                    emit(Result.success(searchResult))
                } ?: emit(Result.failure(Exception("Empty search response")))
            } else {
                Log.e("HaloRepository", "Search failed: HTTP ${response.code()}: ${response.message()}")
                emit(Result.failure(Exception("HTTP ${response.code()}: ${response.message()}")))
            }
        } catch (e: Exception) {
            Log.e("HaloRepository", "Search error: ${e.message}")
            emit(Result.failure(e))
        }
    }
    
    // 获取评论列表
    fun getComments(
        postName: String,
        page: Int = 1,
        size: Int = 20
    ): Flow<Result<CommentResponse>> = flow {
        try {
            Log.d("HaloRepository", "Fetching comments for post: $postName")
            val response = apiService.getComments(
                postName = postName,
                page = page,
                size = size
            )
            
            if (response.isSuccessful) {
                response.body()?.let { commentResponse ->
                    Log.d("HaloRepository", "Comments fetched successfully, total: ${commentResponse.total}")
                    emit(Result.success(commentResponse))
                } ?: emit(Result.failure(Exception("Empty comments response")))
            } else {
                Log.e("HaloRepository", "Failed to fetch comments: HTTP ${response.code()}: ${response.message()}")
                emit(Result.failure(Exception("HTTP ${response.code()}: ${response.message()}")))
            }
        } catch (e: Exception) {
            Log.e("HaloRepository", "Error fetching comments: ${e.message}")
            emit(Result.failure(e))
        }
    }
    
    // 发表评论
    fun createComment(
        apiKey: String,
        commentContent: String,
        postName: String
    ): Flow<Result<Comment>> = flow {
        try {
            Log.d("HaloRepository", "Creating comment for post: $postName")
            
            val commentRequest = CommentRequest(
                raw = commentContent,
                content = commentContent,
                allowNotification = true,
                subjectRef = CommentSubjectRef(
                    group = "content.halo.run",
                    version = "v1alpha1",
                    kind = "Post",
                    name = postName
                )
            )
            
            val authorization = "Bearer $apiKey"
            val response = apiService.createComment(authorization, commentRequest)
            
            if (response.isSuccessful) {
                response.body()?.let { comment ->
                    Log.d("HaloRepository", "Comment created successfully: ${comment.metadata.name}")
                    emit(Result.success(comment))
                } ?: emit(Result.failure(Exception("Empty comment response")))
            } else {
                Log.e("HaloRepository", "Failed to create comment: HTTP ${response.code()}: ${response.message()}")
                emit(Result.failure(Exception("HTTP ${response.code()}: ${response.message()}")))
            }
        } catch (e: Exception) {
            Log.e("HaloRepository", "Error creating comment: ${e.message}")
            emit(Result.failure(e))
        }
    }
}