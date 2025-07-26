package com.halo.blog.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.halo.blog.data.model.CommentItem
import com.halo.blog.data.repository.HaloRepository
import com.halo.blog.utils.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * 评论UI状态
 */
data class CommentUiState(
    val comments: List<CommentItem> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val total: Int = 0,
    val currentPage: Int = 1,
    val hasMore: Boolean = false,
    val isSubmitting: Boolean = false,
    val submitError: String? = null,
    val submitSuccess: Boolean = false
)

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val repository: HaloRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {
    
    private val preferenceManager = PreferenceManager(context)
    
    private val _uiState = MutableStateFlow(CommentUiState())
    val uiState: StateFlow<CommentUiState> = _uiState.asStateFlow()
    
    /**
     * 加载评论
     */
    fun loadComments(postName: String, page: Int = 1) {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(
                    isLoading = true,
                    error = null
                )
                
                repository.getComments(postName, page).collect { result ->
                    result.fold(
                        onSuccess = { commentResponse ->
                            val commentItems = commentResponse.items.mapNotNull { comment ->
                                try {
                                    CommentItem.fromComment(comment)
                                } catch (e: Exception) {
                                    // 如果单个评论转换失败，跳过该评论
                                    null
                                }
                            }
                            
                            _uiState.value = _uiState.value.copy(
                                comments = if (page == 1) commentItems else _uiState.value.comments + commentItems,
                                isLoading = false,
                                error = null,
                                total = commentResponse.total,
                                currentPage = page,
                                hasMore = commentResponse.hasNext
                            )
                        },
                        onFailure = { exception ->
                            _uiState.value = _uiState.value.copy(
                                isLoading = false,
                                error = exception.message ?: "加载评论失败"
                            )
                        }
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "加载评论时发生未知错误"
                )
            }
        }
    }
    
    /**
     * 加载更多评论
     */
    fun loadMoreComments(postName: String) {
        if (!_uiState.value.isLoading && _uiState.value.hasMore) {
            loadComments(postName, _uiState.value.currentPage + 1)
        }
    }
    
    /**
     * 刷新评论
     */
    fun refreshComments(postName: String) {
        loadComments(postName, 1)
    }
    
    /**
     * 清除错误
     */
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
    
    /**
     * 清除评论数据
     */
    fun clearComments() {
        _uiState.value = CommentUiState()
    }
    
    /**
     * 发表评论
     */
    fun submitComment(
        commentContent: String,
        postName: String
    ) {
        val apiKey = preferenceManager.getApiKey()
        if (apiKey.isNullOrBlank()) {
            _uiState.value = _uiState.value.copy(
                submitError = "请先在设置中配置API密钥",
                submitSuccess = false
            )
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isSubmitting = true,
                submitError = null,
                submitSuccess = false
            )
            
            try {
                repository.createComment(apiKey, commentContent, postName).collect { result ->
                    result.fold(
                        onSuccess = { _ ->
                            _uiState.value = _uiState.value.copy(
                                isSubmitting = false,
                                submitError = null,
                                submitSuccess = true
                            )
                            // 延迟一下再刷新评论列表，避免状态冲突
                            kotlinx.coroutines.delay(500)
                            // 在刷新前先清除提交状态，避免状态冲突
                            _uiState.value = _uiState.value.copy(
                                submitSuccess = false
                            )
                            try {
                                refreshComments(postName)
                            } catch (e: Exception) {
                                // 如果刷新失败，不影响评论提交的成功状态
                                _uiState.value = _uiState.value.copy(
                                    error = "评论发表成功，但刷新列表失败：${e.message}"
                                )
                            }
                        },
                        onFailure = { exception ->
                            _uiState.value = _uiState.value.copy(
                                isSubmitting = false,
                                submitError = exception.message ?: "发表评论失败",
                                submitSuccess = false
                            )
                        }
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isSubmitting = false,
                    submitError = e.message ?: "发表评论失败",
                    submitSuccess = false
                )
            }
        }
    }
    
    /**
     * 清除提交状态
     */
    fun clearSubmitStatus() {
        _uiState.value = _uiState.value.copy(
            submitError = null,
            submitSuccess = false
        )
    }
}