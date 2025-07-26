package com.halo.blog.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halo.blog.data.model.PostItem
import com.halo.blog.data.repository.HaloRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TagViewModel @Inject constructor(
    private val repository: HaloRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(TagUiState())
    val uiState: StateFlow<TagUiState> = _uiState.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    private var currentPage = 0
    private var isLastPage = false
    private var currentTagName: String? = null
    
    fun loadTagPosts(tagName: String, refresh: Boolean = true) {
        if (refresh) {
            currentPage = 0
            isLastPage = false
            currentTagName = tagName
            _uiState.value = _uiState.value.copy(posts = emptyList(), tagInfo = null)
            // 加载标签信息
            loadTagInfo(tagName)
        }
        
        if (_isLoading.value || isLastPage) return
        
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            repository.getPosts(
                page = currentPage,
                size = 10,
                tagName = currentTagName
            ).collect { result ->
                result.fold(
                    onSuccess = { postResponse ->
                        val newPosts = postResponse.items.map { PostItem.fromPost(it) }
                        val currentPosts = if (currentPage == 0) {
                            newPosts
                        } else {
                            _uiState.value.posts + newPosts
                        }
                        
                        _uiState.value = _uiState.value.copy(
                            posts = currentPosts
                        )
                        
                        isLastPage = postResponse.last
                        currentPage++
                    },
                    onFailure = { _ ->
                        _error.value = "Unknown error"
                    }
                )
                _isLoading.value = false
            }
        }
    }
    
    private fun loadTagInfo(tagSlug: String) {
        viewModelScope.launch {
            repository.getTagInfo(tagSlug).collect { result ->
                result.fold(
                    onSuccess = { tagInfo ->
                        _uiState.value = _uiState.value.copy(tagInfo = tagInfo)
                    },
                    onFailure = { _ ->
                        // 如果获取标签信息失败，使用tagSlug作为displayName
                        _uiState.value = _uiState.value.copy(
                            tagInfo = com.halo.blog.data.model.TagItem(
                                name = tagSlug,
                                displayName = tagSlug,
                                slug = tagSlug,
                                color = null,
                                cover = null,
                                postCount = 0,
                                permalink = null
                            )
                        )
                    }
                )
            }
        }
    }
    
    fun loadMorePosts() {
        loadTagPosts(currentTagName ?: "", refresh = false)
    }
    
    fun clearError() {
        _error.value = null
    }
}

data class TagUiState(
    val posts: List<PostItem> = emptyList(),
    val tagInfo: com.halo.blog.data.model.TagItem? = null
)