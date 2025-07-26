package com.halo.blog.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.halo.blog.ui.component.EmptyState
import com.halo.blog.ui.component.RefreshIndicator
import com.halo.blog.ui.viewmodel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    categoryName: String,
    onBackClick: () -> Unit,
    onPostClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val isRefreshing by viewModel.isRefreshing.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    // 移除 scrollBehavior，避免使用实验性 API
    
    LaunchedEffect(categoryName) {
        viewModel.filterByCategory(categoryName)
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
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            
            Text(
                text = "分类: $categoryName",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    
        // 内容区域
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            when {
                isLoading && uiState.posts.isEmpty() -> {
                    LoadingIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                error != null -> {
                    ErrorMessage(
                        message = error ?: "未知错误",
                        onRetry = {
                            viewModel.clearError()
                            viewModel.filterByCategory(categoryName)
                        },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                uiState.posts.isEmpty() -> {
                    EmptyState(
                        message = "该分类下暂无文章",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            start = 20.dp,
                            end = 20.dp,
                            top = 16.dp,
                            bottom = 32.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // 顶部刷新指示器
                        if (isRefreshing) {
                            item {
                                RefreshIndicator()
                            }
                        }
                        
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer
                                ),
                                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                            ) {
                                Column(
                                    modifier = Modifier.padding(20.dp)
                                ) {
                                    Text(
                                        text = categoryName,
                                        style = MaterialTheme.typography.headlineSmall,
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "共 ${uiState.posts.size} 篇文章",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
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
                        if (isLoading) {
                            item {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}