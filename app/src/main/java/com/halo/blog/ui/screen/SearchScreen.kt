@file:OptIn(ExperimentalMaterial3Api::class)
package com.halo.blog.ui.screen
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.halo.blog.data.model.SearchType
import com.halo.blog.ui.component.PostCard
import com.halo.blog.ui.component.LoadingIndicator
import com.halo.blog.ui.component.ErrorMessage
import com.halo.blog.ui.component.EmptyState
import com.halo.blog.ui.component.CategoryChip
import com.halo.blog.ui.component.TagChip
import com.halo.blog.ui.component.SearchResultCard
import com.halo.blog.ui.component.RefreshIndicator
import com.halo.blog.ui.viewmodel.PostViewModel
import com.halo.blog.ui.viewmodel.CategoryTagViewModel
import com.halo.blog.ui.viewmodel.SearchViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onBackClick: () -> Unit,
    onPostClick: (String) -> Unit,
    onCategoryClick: (String) -> Unit = {},
    onTagClick: (String) -> Unit = {},
    modifier: Modifier = Modifier,
    // viewModel: PostViewModel = hiltViewModel(),
    searchViewModel: SearchViewModel = hiltViewModel(),
    categoryTagViewModel: CategoryTagViewModel = hiltViewModel()
) {
    // val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val searchUiState by searchViewModel.uiState.collectAsStateWithLifecycle()
    // val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val searchIsLoading by searchViewModel.isLoading.collectAsStateWithLifecycle()
    val searchIsRefreshing by searchViewModel.isRefreshing.collectAsStateWithLifecycle()
    // val error by viewModel.error.collectAsStateWithLifecycle()
    val searchError by searchViewModel.error.collectAsStateWithLifecycle()
    
    val categories by categoryTagViewModel.categories.collectAsStateWithLifecycle()
    val tags by categoryTagViewModel.tags.collectAsStateWithLifecycle()
    
    var searchQuery by remember { mutableStateOf("") }
    var hasSearched by remember { mutableStateOf(false) }
    // var selectedSearchType by remember { mutableStateOf(SearchType.ALL) }
    // 临时注释 keyboardController，因为它使用了实验性 API
    // val keyboardController = LocalSoftwareKeyboardController.current
    // 临时注释 scrollBehavior，因为它使用了实验性 API
    // val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    
    // 不使用 Scaffold，直接使用 Column 布局
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // 使用简单的 Box 作为顶部栏
        Box(modifier = Modifier.fillMaxWidth().height(56.dp)) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            
            Text(
                text = "搜索",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        
        // 内容区域
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // 搜索框
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text(
                        text = "搜索文章...",
                        style = MaterialTheme.typography.bodyLarge
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                searchQuery = ""
                                hasSearched = false
                                searchViewModel.clearSearch()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        if (searchQuery.isNotBlank()) {
                            // 使用新的搜索API
                            searchViewModel.searchContent(
                                keyword = searchQuery.trim(),
                                limit = 20
                            )
                            hasSearched = true
                            // 临时注释 keyboardController，因为它使用了实验性 API
                            // keyboardController?.hide()
                        }
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                shape = MaterialTheme.shapes.large
            )
            
            // 搜索结果统计（如果有搜索结果）
            if (hasSearched && searchUiState.searchResults.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "搜索: ${searchUiState.keyword}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    
                    Text(
                        text = "${searchUiState.total} 个结果",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            // 内容区域
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                when {
                    !hasSearched -> {
                        // 搜索提示和分类标签展示
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(24.dp)
                        ) {
                            item {
                                // 搜索提示
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null,
                                        modifier = Modifier.size(64.dp),
                                        tint = MaterialTheme.colorScheme.primary
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(
                                        text = "输入关键词搜索文章",
                                        style = MaterialTheme.typography.headlineSmall,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "搜索标题、内容、标签等",
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                            
                            // 分类列表
                            if (categories.isNotEmpty()) {
                                item {
                                    Column {
                                        Text(
                                            text = "分类",
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.padding(bottom = 12.dp)
                                        )
                                        LazyRow(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            items(categories) { category ->
                                                CategoryChip(
                                                    category = category,
                                                    onClick = { onCategoryClick(category.name) }
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            
                            // 标签列表
                            if (tags.isNotEmpty()) {
                                item {
                                    Column {
                                        Text(
                                            text = "标签",
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold,
                                            color = MaterialTheme.colorScheme.onSurface,
                                            modifier = Modifier.padding(bottom = 12.dp)
                                        )
                                        LazyRow(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            items(tags) { tag ->
                                                TagChip(
                                                    tag = tag,
                                                    onClick = { onTagClick(tag.name) }
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                    searchIsLoading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            LoadingIndicator()
                        }
                    }
                    
                    searchError != null -> {
                        ErrorMessage(
                            message = searchError ?: "未知错误",
                            onRetry = {
                                searchViewModel.clearError()
                                if (searchQuery.isNotBlank()) {
                                    searchViewModel.searchContent(
                                        keyword = searchQuery.trim(),
                                        limit = 20
                                    )
                                }
                            },
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                    searchUiState.searchResults.isEmpty() && hasSearched -> {
                        EmptyState(
                            message = "没有找到相关文章",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    
                    searchUiState.searchResults.isNotEmpty() -> {
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
                            if (searchIsRefreshing) {
                                item {
                                    RefreshIndicator()
                                }
                            }
                            
                            item {
                                Column {
                                    Text(
                                        text = "找到 ${searchUiState.total} 个结果",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                    Text(
                                        text = "搜索耗时 ${searchUiState.processingTime}ms",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                }
                            }
                            
                            items(
                                items = searchUiState.searchResults,
                                key = { it.id }
                            ) { searchResult ->
                                SearchResultCard(
                                    searchResult = searchResult,
                                    onItemClick = onPostClick
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}