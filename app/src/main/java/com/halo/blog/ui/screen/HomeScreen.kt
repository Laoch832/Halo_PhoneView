package com.halo.blog.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.halo.blog.ui.component.PostCard
import com.halo.blog.ui.component.LoadingIndicator
import com.halo.blog.ui.component.ErrorMessage
import com.halo.blog.ui.component.RefreshIndicator
import com.halo.blog.ui.viewmodel.PostViewModel
import com.halo.blog.utils.LogUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onPostClick: (String) -> Unit,
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    
    // 添加调试日志
    LaunchedEffect(uiState.posts.size, isLoading, error) {
        LogUtils.d("HomeScreen", "UI状态更新 - 文章数量: ${uiState.posts.size}, 加载中: $isLoading, 错误: $error")
    }
    
    val listState = rememberLazyListState()
    
    // 检测是否滚动到底部，触发加载更多
    LaunchedEffect(listState) {
        snapshotFlow {
            val layoutInfo = listState.layoutInfo
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
            
            lastVisibleItemIndex > (totalItemsNumber - 3)
        }.collect { shouldLoadMore ->
            if (shouldLoadMore && !isLoading) {
                viewModel.loadMorePosts()
            }
        }
    }
    
    // 使用 Column 替代 Scaffold，避免使用实验性 API
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // 简化的顶部栏
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .padding(horizontal = 16.dp)
        ) {
            IconButton(
                onClick = onSettingsClick,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            
            Text(
                text = "Halo Blog",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
            
            IconButton(
                onClick = onSearchClick,
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
        // 内容区域
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when {
                error != null -> {
                    ErrorMessage(
                        message = error ?: "未知错误",
                        onRetry = {
                            viewModel.clearError()
                            viewModel.loadPosts(refresh = true)
                        },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                uiState.posts.isEmpty() && isLoading -> {
                    LoadingIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                uiState.posts.isEmpty() && !isLoading -> {
                    // 显示空状态
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "暂无文章",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextButton(
                            onClick = { viewModel.loadPosts(refresh = true) }
                        ) {
                            Text("重新加载")
                        }
                    }
                }
                
                else -> {
                    LazyColumn(
                        state = listState,
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            end = 16.dp,
                            top = 8.dp,
                            bottom = 16.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // 顶部刷新指示器
                        if (isRefreshing) {
                            item {
                                RefreshIndicator()
                            }
                        }
                        
                        items(
                            items = uiState.posts,
                            key = { it.name }
                        ) { post ->
                            PostCard(
                                post = post,
                                onClick = { onPostClick(post.name) }
                            )
                        }
                        
                        // 底部加载指示器
                        if (isLoading && uiState.posts.isNotEmpty()) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator(
                                        modifier = Modifier.size(32.dp),
                                        strokeWidth = 3.dp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}