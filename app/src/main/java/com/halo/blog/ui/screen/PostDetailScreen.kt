@file:OptIn(ExperimentalMaterial3Api::class)
package com.halo.blog.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.halo.blog.ui.component.LoadingIndicator
import com.halo.blog.ui.component.ErrorMessage
import com.halo.blog.ui.component.HtmlContent
import com.halo.blog.ui.component.HtmlTextContent
import com.halo.blog.ui.component.TagChip
import com.halo.blog.ui.component.CategoryChip
import com.halo.blog.ui.component.RefreshIndicator
import com.halo.blog.ui.components.CommentCard
import com.halo.blog.ui.components.CommentInput
import com.halo.blog.ui.viewmodel.PostViewModel
import com.halo.blog.ui.viewmodel.CommentViewModel
import com.halo.blog.utils.formatDate
import com.halo.blog.utils.UrlUtils
import android.util.Log

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetailScreen(
    postName: String,
    onBackClick: () -> Unit,
    onCategoryClick: (String) -> Unit,
    onTagClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel(),
    commentViewModel: CommentViewModel = hiltViewModel()
) {
    val postDetail by viewModel.postDetail.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    val isDetailRefreshing by viewModel.isDetailRefreshing.collectAsStateWithLifecycle()
    
    LaunchedEffect(postName) {
        viewModel.loadPostDetail(postName)
    }
    
    DisposableEffect(Unit) {
        onDispose {
            viewModel.clearPostDetail()
        }
    }
    
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // 顶部导航栏
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 4.dp
        ) {
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
                        contentDescription = "返回",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                
                Text(
                    text = "文章详情",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        
        // 内容区域
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            when {
                isLoading -> {
                    LoadingIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                error != null -> {
                    ErrorMessage(
                        message = error ?: "未知错误",
                        onRetry = {
                            viewModel.clearError()
                            viewModel.loadPostDetail(postName)
                        },
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                
                postDetail != null -> {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // 刷新指示器
                        if (isDetailRefreshing) {
                            RefreshIndicator()
                        }
                        
                        PostDetailContent(
                            postDetail = postDetail!!,
                            postName = postName,
                            onCategoryClick = onCategoryClick,
                            onTagClick = onTagClick,
                            commentViewModel = commentViewModel,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun PostDetailContent(
    postDetail: com.halo.blog.data.model.PostDetail,
    postName: String,
    onCategoryClick: (String) -> Unit,
    onTagClick: (String) -> Unit,
    commentViewModel: CommentViewModel,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    
    // 评论相关状态
    val commentUiState by commentViewModel.uiState.collectAsStateWithLifecycle()
    
    // 加载评论
    LaunchedEffect(postName) {
        commentViewModel.loadComments(postName)
    }
    
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // 文章标题
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = postDetail.post.spec.title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                
                // 文章元信息
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    postDetail.post.spec.publishTime?.let { publishTime ->
                        Text(
                            text = formatDate(publishTime),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                        )
                    }
                    
                    if (postDetail.post.status?.commentsCount != null && postDetail.post.status.commentsCount > 0) {
                        Text(
                            text = "${postDetail.post.status.commentsCount} 条评论",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
        
        // 封面图片
        postDetail.post.spec.cover?.let { cover ->
            val fullImageUrl = UrlUtils.buildImageUrl(context, cover)
            if (fullImageUrl != null) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    AsyncImage(
                        model = fullImageUrl,
                        contentDescription = "文章封面",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
        
        // 文章摘要 - 由于API返回的摘要可能被截断，暂时隐藏摘要部分
        // 用户可以直接阅读下方的完整正文内容
        // postDetail.post.status?.excerpt?.let { excerpt ->
        //     if (excerpt.isNotBlank()) {
        //         Card(
        //             modifier = Modifier.fillMaxWidth(),
        //             colors = CardDefaults.cardColors(
        //                 containerColor = MaterialTheme.colorScheme.secondaryContainer
        //             ),
        //             elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        //         ) {
        //             Column(
        //                 modifier = Modifier.padding(16.dp)
        //             ) {
        //                 Text(
        //                     text = "摘要",
        //                     style = MaterialTheme.typography.titleMedium,
        //                     fontWeight = FontWeight.Medium,
        //                     color = MaterialTheme.colorScheme.onSecondaryContainer,
        //                     modifier = Modifier.padding(bottom = 8.dp)
        //                 )
        //                 Text(
        //                     text = excerpt,
        //                     style = MaterialTheme.typography.bodyLarge,
        //                     color = MaterialTheme.colorScheme.onSecondaryContainer
        //                 )
        //             }
        //         }
        //     }
        // }
        
        // 分类和标签
        if (!postDetail.categories.isNullOrEmpty() || !postDetail.tags.isNullOrEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // 分类
                    if (!postDetail.categories.isNullOrEmpty()) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "分类",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                postDetail.categories.forEach { category ->
                                    CategoryChip(
                                        category = category,
                                        onClick = { onCategoryClick(category.name) }
                                    )
                                }
                            }
                        }
                    }
                    
                    // 标签
                    if (!postDetail.tags.isNullOrEmpty()) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "标签",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                postDetail.tags.forEach { tag ->
                                    TagChip(
                                        tag = tag,
                                        onClick = { onTagClick(tag.slug) }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        
        // 文章内容 - 添加调试日志
        postDetail.content?.spec?.content?.let { htmlContent ->
            Log.d("PostDetail", "HTML Content length: ${htmlContent.length}")
            Log.d("PostDetail", "HTML Content preview: ${htmlContent.take(200)}")
            
            if (htmlContent.isNotBlank()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "正文",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium
                        )
                        
                        Spacer(modifier = Modifier.height(12.dp))
                        
                        // 使用HtmlContent来显示包含图片的完整内容
                        HtmlContent(
                            html = htmlContent,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            } else {
                Log.d("PostDetail", "HTML Content is blank")
                // 显示调试信息
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) {
                    Text(
                        text = "调试信息：HTML内容为空",
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
        } ?: run {
            Log.d("PostDetail", "PostDetail content is null")
            // 显示调试信息
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Text(
                    text = "调试信息：文章内容为null",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
            }
        }
        
        // 评论部分
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 评论标题
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "评论",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Medium
                    )
                    
                    if (commentUiState.total > 0) {
                        Text(
                            text = "共 ${commentUiState.total} 条",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                // 评论输入组件
                CommentInput(
                    onSubmitComment = { content ->
                        commentViewModel.submitComment(content, postName)
                    },
                    isSubmitting = commentUiState.isSubmitting,
                    submitError = commentUiState.submitError,
                    submitSuccess = commentUiState.submitSuccess,
                    onClearSubmitStatus = { commentViewModel.clearSubmitStatus() }
                )
                
                // 评论内容
                when {
                    commentUiState.isLoading -> {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                    
                    commentUiState.error != null -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = commentUiState.error ?: "加载评论失败",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.error
                            )
                            Button(
                                onClick = { commentViewModel.refreshComments(postName) }
                            ) {
                                Text("重试")
                            }
                        }
                    }
                    
                    commentUiState.comments.isEmpty() -> {
                        Text(
                            text = "暂无评论",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                    }
                    
                    else -> {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            commentUiState.comments.forEach { comment ->
                                CommentCard(
                                    comment = comment,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                            
                            // 加载更多按钮
                            if (commentUiState.hasMore) {
                                Button(
                                    onClick = { commentViewModel.loadMoreComments(postName) },
                                    modifier = Modifier.fillMaxWidth(),
                                    enabled = !commentUiState.isLoading
                                ) {
                                    if (commentUiState.isLoading) {
                                        CircularProgressIndicator(
                                            modifier = Modifier.size(16.dp),
                                            strokeWidth = 2.dp
                                        )
                                    } else {
                                        Text("加载更多评论")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}