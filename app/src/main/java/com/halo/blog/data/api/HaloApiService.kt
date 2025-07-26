package com.halo.blog.data.api

import com.halo.blog.data.model.*
import com.halo.blog.data.model.Tag
import com.halo.blog.data.model.SearchOption
import com.halo.blog.data.model.SearchResult
import com.halo.blog.data.model.CommentResponse
import retrofit2.Response
import retrofit2.http.*

interface HaloApiService {
    
    // 获取文章列表
    @GET("apis/api.content.halo.run/v1alpha1/posts")
    suspend fun getPosts(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") sort: String = "metadata.creationTimestamp,desc",
        @Query("labelSelector") labelSelector: String? = null,
        @Query("fieldSelector") fieldSelector: String? = null
    ): Response<PostResponse>
    
    // 获取单个文章
    @GET("apis/api.content.halo.run/v1alpha1/posts/{name}")
    suspend fun getPost(@Path("name") name: String): Response<Post>
    
    // 获取文章内容
    @GET("apis/api.content.halo.run/v1alpha1/posts/{name}/content")
    suspend fun getPostContent(@Path("name") name: String): Response<PostContent>
    
    // 获取分类列表
    @GET("apis/api.content.halo.run/v1alpha1/categories")
    suspend fun getCategories(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 0,
        @Query("sort") sort: String = "metadata.creationTimestamp,desc"
    ): Response<CategoryResponse>
    
    // 获取单个分类
    @GET("apis/api.content.halo.run/v1alpha1/categories/{name}")
    suspend fun getCategory(@Path("name") name: String): Response<Category>
    
    // 获取标签列表
    @GET("apis/api.content.halo.run/v1alpha1/tags")
    suspend fun getTags(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 0,
        @Query("sort") sort: String = "metadata.creationTimestamp,desc"
    ): Response<TagResponse>
    
    // 获取单个标签
    @GET("apis/api.content.halo.run/v1alpha1/tags/{name}")
    suspend fun getTag(@Path("name") name: String): Response<Tag>
    
    // 根据分类获取文章
    @GET("apis/api.content.halo.run/v1alpha1/posts")
    suspend fun getPostsByCategory(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") sort: String = "metadata.creationTimestamp,desc",
        @Query("fieldSelector") fieldSelector: String // spec.categories=category-name
    ): Response<PostResponse>
    
    // 根据标签获取文章
    @GET("apis/api.content.halo.run/v1alpha1/posts")
    suspend fun getPostsByTag(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") sort: String = "metadata.creationTimestamp,desc",
        @Query("fieldSelector") fieldSelector: String // spec.tags=tag-name
    ): Response<PostResponse>
    
    // 新的搜索API - 使用官方搜索接口
    @POST("apis/api.halo.run/v1alpha1/indices/-/search")
    suspend fun searchContent(
        @Body searchOption: SearchOption
    ): Response<SearchResult>
    
    /**
     * 获取文章评论
     */
    @GET("apis/api.halo.run/v1alpha1/comments")
    suspend fun getComments(
        @Query("group") group: String = "content.halo.run",
        @Query("kind") kind: String = "Post",
        @Query("name") postName: String,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 20,
        @Query("version") version: String = "v1alpha1",
        @Query("withReplies") withReplies: Boolean = false,
        @Query("replySize") replySize: Int = 5
    ): Response<CommentResponse>
    
    /**
     * 发表评论
     */
    @POST("apis/api.halo.run/v1alpha1/comments")
    suspend fun createComment(
        @Header("Authorization") authorization: String,
        @Body commentRequest: CommentRequest
    ): Response<Comment>
    
    // 搜索文章（全部）- 保留旧接口作为备用
    @GET("apis/api.content.halo.run/v1alpha1/posts")
    suspend fun searchPosts(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") sort: String = "metadata.creationTimestamp,desc",
        @Query("keyword") keyword: String
    ): Response<PostResponse>
    
    // 搜索文章标题
    @GET("apis/api.content.halo.run/v1alpha1/posts")
    suspend fun searchPostsByTitle(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") sort: String = "metadata.creationTimestamp,desc",
        @Query("fieldSelector") fieldSelector: String // spec.title~keyword
    ): Response<PostResponse>
    
    // 搜索文章内容
    @GET("apis/api.content.halo.run/v1alpha1/posts")
    suspend fun searchPostsByContent(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 10,
        @Query("sort") sort: String = "metadata.creationTimestamp,desc",
        @Query("keyword") keyword: String
    ): Response<PostResponse>
}