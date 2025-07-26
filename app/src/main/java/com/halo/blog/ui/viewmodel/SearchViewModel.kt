package com.halo.blog.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halo.blog.data.model.SearchResult
import com.halo.blog.data.model.SearchResultItem
import com.halo.blog.data.repository.HaloRepository
import com.halo.blog.utils.LogUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SearchUiState(
    val searchResults: List<SearchResultItem> = emptyList(),
    val keyword: String = "",
    val total: Int = 0,
    val processingTime: Int = 0
)

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: HaloRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    fun searchContent(
        keyword: String,
        limit: Int = 10,
        includeTypes: List<String>? = listOf("post.content.halo.run"),
        includeCategoryNames: List<String>? = null,
        includeTagNames: List<String>? = null
    ) {
        if (keyword.isBlank()) {
            _uiState.value = SearchUiState()
            return
        }
        
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            LogUtils.d("SearchViewModel", "开始搜索，关键词: $keyword")
            
            repository.searchContent(
                keyword = keyword.trim(),
                limit = limit,
                includeTypes = includeTypes,
                includeCategoryNames = includeCategoryNames,
                includeTagNames = includeTagNames
            ).collect { result ->
                result.fold(
                    onSuccess = { searchResult ->
                        LogUtils.d("SearchViewModel", "搜索成功，找到 ${searchResult.total} 个结果")
                        
                        val searchResultItems = searchResult.hits.map { 
                            SearchResultItem.fromHaloDocument(it) 
                        }
                        
                        _uiState.value = SearchUiState(
                            searchResults = searchResultItems,
                            keyword = searchResult.keyword,
                            total = searchResult.total,
                            processingTime = searchResult.processingTimeMillis
                        )
                    },
                    onFailure = { exception ->
                        LogUtils.e("SearchViewModel", "搜索失败: ${exception.message}")
                        _error.value = exception.message ?: "搜索失败"
                        _uiState.value = SearchUiState(keyword = keyword)
                    }
                )
                _isLoading.value = false
            }
        }
    }
    
    fun clearSearch() {
        _uiState.value = SearchUiState()
        _error.value = null
    }
    
    fun clearError() {
        _error.value = null
    }
}