package com.halo.blog.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.halo.blog.data.model.UpdateInfo
import com.halo.blog.utils.ApkDownloadManager

/**
 * 更新提示对话框
 */
@Composable
fun UpdateDialog(
    updateInfo: UpdateInfo,
    onDownload: () -> Unit,
    onDismiss: () -> Unit,
    downloadStatus: ApkDownloadManager.DownloadStatus? = null
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = downloadStatus !is ApkDownloadManager.DownloadStatus.Started,
            dismissOnClickOutside = downloadStatus !is ApkDownloadManager.DownloadStatus.Started
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 标题图标
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "更新",
                    modifier = Modifier.size(48.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 标题
                Text(
                    text = "发现新版本",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // 版本信息
                Text(
                    text = "v${updateInfo.version}",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 更新内容
                if (!updateInfo.description.isNullOrBlank()) {
                    Text(
                        text = "更新内容:",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Medium
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 200.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Text(
                            text = updateInfo.description!!,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)
                                .verticalScroll(rememberScrollState())
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
                
                // 文件大小
                if (updateInfo.fileSize > 0) {
                    Text(
                        text = "文件大小: ${formatFileSize(updateInfo.fileSize)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
                
                // 下载状态显示
                when (downloadStatus) {
                    is ApkDownloadManager.DownloadStatus.Started -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(32.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "正在下载...,请检查通知栏,如没有自动跳转",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                    is ApkDownloadManager.DownloadStatus.Completed -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = "下载完成",
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "下载完成，安装包已自动打开",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = onDismiss,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("关闭")
                            }
                        }
                    }
                    is ApkDownloadManager.DownloadStatus.Failed -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "下载失败",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.error
                            )
                            Text(
                                text = downloadStatus.error,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onErrorContainer
                            )
                        }
                    }
                    else -> {
                        // 按钮区域
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            OutlinedButton(
                                onClick = onDismiss,
                                modifier = Modifier.weight(1f)
                            ) {
                                Text("稍后更新")
                            }
                            
                            Button(
                                onClick = onDownload,
                                modifier = Modifier.weight(1f)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = null,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("立即下载")
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * 格式化文件大小
 */
private fun formatFileSize(bytes: Long): String {
    val kb = 1024
    val mb = kb * 1024
    val gb = mb * 1024
    
    return when {
        bytes >= gb -> String.format("%.1f GB", bytes.toDouble() / gb)
        bytes >= mb -> String.format("%.1f MB", bytes.toDouble() / mb)
        bytes >= kb -> String.format("%.1f KB", bytes.toDouble() / kb)
        else -> "$bytes B"
    }
}