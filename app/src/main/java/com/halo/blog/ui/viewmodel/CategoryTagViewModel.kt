package com.halo.blog.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halo.blog.data.model.CategoryItem
import com.halo.blog.data.model.TagItem
import com.halo.blog.data.repository.HaloRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryTagViewModel @Inject constructor(
    private val repository: HaloRepository
) : ViewModel() {
    
    private val _categories = MutableStateFlow<List<CategoryItem>>(emptyList())
    val categories: StateFlow<List<CategoryItem>> = _categories.asStateFlow()
    
    private val _tags = MutableStateFlow<List<TagItem>>(emptyList())
    val tags: StateFlow<List<TagItem>> = _tags.asStateFlow()
    
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()
    
    init {
        loadCategories()
        loadTags()
    }
    
    fun loadCategories() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            repository.getCategories().collect { result ->
                result.fold(
                    onSuccess = { categories ->
                        _categories.value = categories
                    },
                    onFailure = { exception ->
                        _error.value = exception.message ?: "Failed to load categories"
                    }
                )
                _isLoading.value = false
            }
        }
    }
    
    fun loadTags() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            
            repository.getTags().collect { result ->
                result.fold(
                    onSuccess = { tags ->
                        _tags.value = tags
                    },
                    onFailure = { exception ->
                        _error.value = exception.message ?: "Failed to load tags"
                    }
                )
                _isLoading.value = false
            }
        }
    }
    
    fun clearError() {
        _error.value = null
    }
}