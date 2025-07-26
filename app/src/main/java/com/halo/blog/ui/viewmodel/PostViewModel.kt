package com.halo.blog.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halo.blog.data.model.PostItem
import com.halo.blog.data.model.PostDetail
import com.halo.blog.data.model.SearchType
import com.halo.blog.data.repository.HaloRepository
import com.halo.blog.utils.LogUtils
import com.halo.blog.utils.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: HaloRepository,
    private val preferenceManager: PreferenceManager
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(PostUiState())
    val uiState: StateFlow<PostUiState> = _uiState.asStateFlow()
    
    private val _postDetail = MutableStateFlow<PostDetail?>(null)
    val postDetail: StateFlow<PostDetail?> = _postDetail.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()
    
    private val _isDetailRefreshing = MutableStateFlow(false)
    val isDetailRefreshing: StateFlow<Boolean> = _isDetailRefreshing.asStateFlow()
    
    private var currentPage = 0
    private var isLastPage = false
    private var currentCategory: String? = null
    private var currentTag: String? = null
    private var currentKeyword: String? = null
    
    init {
        loadCachedPostsFirst()
    }
    
    /**
     * 首先加载缓存数据，然后在后台刷新
     */
    private fun loadCachedPostsFirst() {
        // 先尝试加载缓存数据
        val cachedPosts = preferenceManager.getCachedPostList()
        if (cachedPosts != null && cachedPosts.isNotEmpty()) {
            LogUtils.d("PostViewModel", "加载缓存文章数据，数量: ${cachedPosts.size}")
            _uiState.value = _uiState.value.copy(posts = cachedPosts)
            
            // 如果缓存有效，在后台刷新数据
            if (preferenceManager.isCacheValid()) {
                loadPostsFromServer(showRefreshIndicator = true)
            } else {
                // 缓存过期，直接刷新
                loadPostsFromServer(showRefreshIndicator = false)
            }
        } else {
            // 没有缓存，直接加载
            LogUtils.d("PostViewModel", "没有缓存数据，直接从服务器加载")
            loadPostsFromServer(showRefreshIndicator = false)
        }
    }
    
    /**
     * 从服务器加载文章数据
     */
    private fun loadPostsFromServer(
        showRefreshIndicator: Boolean = false,
        refresh: Boolean = false,
        categoryName: String? = null,
        tagName: String? = null,
        keyword: String? = null,
        searchType: SearchType = SearchType.ALL
    ) {
        if (refresh) {
            currentPage = 0
            isLastPage = false
            currentCategory = categoryName
            currentTag = tagName
            currentKeyword = keyword
            if (!showRefreshIndicator) {
                _uiState.value = _uiState.value.copy(posts = emptyList())
            }
        }
        
        if (_isLoading.value || isLastPage) return
        
        viewModelScope.launch {
            if (showRefreshIndicator) {
                _isRefreshing.value = true
            } else {
                _isLoading.value = true
            }
            _error.value = null
            
            LogUtils.d("PostViewModel", "开始从服务器加载文章列表，页码: $currentPage")
            
            repository.getPosts(
                page = currentPage,
                size = 10,
                categoryName = currentCategory,
                tagName = currentTag,
                keyword = currentKeyword,
                searchType = searchType
            ).collect { result ->
                result.fold(
                    onSuccess = { postResponse ->
                        LogUtils.d("PostViewModel", "成功获取文章数据，文章数量: ${postResponse.items.size}")
                        LogUtils.d("PostViewModel", "分页信息 - 当前页: ${postResponse.page}, 总页数: ${postResponse.totalPages}, 总数: ${postResponse.total}")
                        
                        val newPosts = postResponse.items.map { PostItem.fromPost(it) }
                        val currentPosts = if (currentPage == 0) {
                            newPosts
                        } else {
                            _uiState.value.posts + newPosts
                        }
                        
                        LogUtils.d("PostViewModel", "更新UI状态，当前文章总数: ${currentPosts.size}")
                        
                        _uiState.value = _uiState.value.copy(
                            posts = currentPosts
                        )
                        
                        // 缓存首页数据
                        if (currentPage == 0 && currentCategory == null && currentTag == null && currentKeyword == null) {
                            preferenceManager.cachePostList(newPosts)
                        }
                        
                        isLastPage = postResponse.last
                        currentPage++
                    },
                    onFailure = { exception ->
                        LogUtils.e("PostViewModel", "加载文章失败: ${exception.message}")
                        _error.value = exception.message ?: "Unknown error"
                    }
                )
                _isLoading.value = false
                _isRefreshing.value = false
            }
        }
    }
    
    /**
     * 公开的加载文章方法
     */
    fun loadPosts(
        refresh: Boolean = false,
        categoryName: String? = null,
        tagName: String? = null,
        keyword: String? = null,
        searchType: SearchType = SearchType.ALL
    ) {
        loadPostsFromServer(
            showRefreshIndicator = false,
            refresh = refresh,
            categoryName = categoryName,
            tagName = tagName,
            keyword = keyword,
            searchType = searchType
        )
    }
    
    fun loadMorePosts() {
        loadPostsFromServer()
    }
    
    fun loadPostDetail(postName: String) {
        // 先尝试加载缓存数据
        val cachedPostContent = preferenceManager.getCachedPostContent(postName)
        if (cachedPostContent != null) {
            LogUtils.d("PostViewModel", "加载缓存文章详情，ID: $postName")
            // 构建PostDetail对象（这里简化处理，实际可能需要更完整的数据）
             val cachedPostDetail = PostDetail(
                 post = com.halo.blog.data.model.Post(
                     metadata = com.halo.blog.data.model.PostMetadata(
                         name = postName,
                         labels = null,
                         annotations = null,
                         creationTimestamp = "",
                         version = null
                     ),
                     spec = com.halo.blog.data.model.PostSpec(
                         title = "加载中...",
                         slug = postName,
                         template = null,
                         cover = null,
                         deleted = false,
                         publish = true,
                         publishTime = null,
                         pinned = false,
                         allowComment = true,
                         visible = "PUBLIC",
                         priority = 0,
                         excerpt = com.halo.blog.data.model.PostExcerpt(autoGenerate = true, raw = ""),
                         categories = null,
                         tags = null,
                         htmlMetas = null
                     ),
                     status = null,
                     content = com.halo.blog.data.model.PostContentData(
                         raw = cachedPostContent.spec.raw,
                         content = cachedPostContent.spec.content
                     )
                 ),
                 content = cachedPostContent,
                 categories = null,
                 tags = null,
                 prevPost = null,
                 nextPost = null
             )
             _postDetail.value = cachedPostDetail
            
            // 如果缓存有效，在后台刷新数据
            if (preferenceManager.isPostContentCacheValid(postName)) {
                loadPostDetailFromServer(postName, showRefreshIndicator = true)
            } else {
                // 缓存过期，直接刷新
                loadPostDetailFromServer(postName, showRefreshIndicator = false)
            }
        } else {
            // 没有缓存，直接加载
            LogUtils.d("PostViewModel", "没有缓存数据，直接从服务器加载文章详情")
            loadPostDetailFromServer(postName, showRefreshIndicator = false)
        }
    }
    
    private fun loadPostDetailFromServer(postName: String, showRefreshIndicator: Boolean = false) {
        viewModelScope.launch {
            if (showRefreshIndicator) {
                _isDetailRefreshing.value = true
            } else {
                _isLoading.value = true
            }
            _error.value = null
            
            LogUtils.d("PostViewModel", "开始从服务器加载文章详情，ID: $postName")
            
            repository.getPostDetail(postName).collect { result ->
                result.fold(
                    onSuccess = { postDetail ->
                        LogUtils.d("PostViewModel", "成功获取文章详情，标题: ${postDetail.post.spec.title}")
                        _postDetail.value = postDetail
                        
                        // 缓存文章详情内容
                        postDetail.content?.let { content ->
                            preferenceManager.cachePostContent(postName, content)
                        }
                    },
                    onFailure = { exception ->
                        LogUtils.e("PostViewModel", "加载文章详情失败: ${exception.message}")
                        _error.value = exception.message ?: "Unknown error"
                    }
                )
                _isLoading.value = false
                _isDetailRefreshing.value = false
            }
        }
    }
    
    fun searchPosts(keyword: String, searchType: SearchType = SearchType.ALL) {
        loadPosts(refresh = true, keyword = keyword, searchType = searchType)
    }
    
    fun filterByCategory(categoryName: String) {
        loadPosts(refresh = true, categoryName = categoryName)
    }
    
    fun filterByTag(tagName: String) {
        loadPosts(refresh = true, tagName = tagName)
    }
    
    fun clearError() {
        _error.value = null
    }
    
    fun clearPostDetail() {
        _postDetail.value = null
    }
}

data class PostUiState(
    val posts: List<PostItem> = emptyList()
)