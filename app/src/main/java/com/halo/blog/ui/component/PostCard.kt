@file:OptIn(ExperimentalMaterial3Api::class)
package com.halo.blog.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.halo.blog.data.model.PostItem
import com.halo.blog.utils.formatDate
import com.halo.blog.utils.UrlUtils

@Composable
fun PostCard(
    post: PostItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp,
            pressedElevation = 2.dp,
            focusedElevation = 2.dp,
            hoveredElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 置顶标识
            if (post.pinned) {
                AssistChip(
                    onClick = { },
                    label = {
                        Text(
                            text = "置顶",
                            style = MaterialTheme.typography.labelMedium
                        )
                    },
                    modifier = Modifier.align(Alignment.Start),
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        labelColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
            }
            
            // 封面图片
            post.cover?.takeIf { it.isNotBlank() }?.let { cover ->
                val fullImageUrl = UrlUtils.buildImageUrl(context, cover)
                if (fullImageUrl != null) {
                    AsyncImage(
                        model = fullImageUrl,
                        contentDescription = "Post cover",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            
            // 文章标题
            Text(
                text = post.title,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            // 文章摘要
            post.excerpt?.let { excerpt ->
                if (excerpt.isNotBlank()) {
                    Text(
                        text = excerpt,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = MaterialTheme.typography.bodyLarge.lineHeight
                    )
                }
            }
            
            // 分类和标签
            if (!post.categories.isNullOrEmpty() || !post.tags.isNullOrEmpty()) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // 显示第一个分类
                    post.categories?.firstOrNull()?.let { category ->
                        FilterChip(
                            onClick = { },
                            label = {
                                Text(
                                    text = category,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            },
                            selected = false,
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                labelColor = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        )
                    }
                    
                    // 显示前两个标签
                    post.tags?.take(2)?.forEach { tag ->
                        FilterChip(
                            onClick = { },
                            label = {
                                Text(
                                    text = tag,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            },
                            selected = false,
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                labelColor = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        )
                    }
                }
            }
            
            // 底部信息
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 发布时间
                post.publishTime?.let { publishTime ->
                    Text(
                        text = formatDate(publishTime),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                // 评论数
                if (post.commentsCount > 0) {
                    Text(
                        text = "${post.commentsCount} 条评论",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}