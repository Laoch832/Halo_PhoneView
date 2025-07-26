package com.halo.blog.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Slider
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.halo.blog.utils.PreferenceManager
import com.halo.blog.utils.AutoUpdateManager
import com.halo.blog.utils.UpdateChecker
import com.halo.blog.ui.components.UpdateDialog
import androidx.compose.material.icons.filled.Refresh
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import com.halo.blog.data.model.UpdateInfo
import com.halo.blog.utils.UpdateManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onServerChanged: () -> Unit
) {
    val context = LocalContext.current
    val preferenceManager = remember { PreferenceManager(context) }
    val coroutineScope = rememberCoroutineScope()
    
    // 服务器选项
    val serverOptions = listOf(
        "服务器1" to "http://192.168.0.30:114",
        "服务器2" to "https://www.120505.xyz"
    )
    
    var selectedServer by remember { 
        mutableStateOf(preferenceManager.getSelectedServer() ?: serverOptions[0].second) 
    }
    
    // API密钥相关状态
    var apiKey by remember { mutableStateOf(preferenceManager.getApiKey() ?: "") }
    var showApiKey by remember { mutableStateOf(false) }
    var showApiKeySuccess by remember { mutableStateOf(false) }
    
    // 监听API密钥变化，自动清除成功状态
    LaunchedEffect(apiKey) {
        if (showApiKeySuccess && apiKey != preferenceManager.getApiKey()) {
            showApiKeySuccess = false
        }
    }
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // 顶部栏
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
                text = "设置",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        
        // 设置内容
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            Text(
                text = "服务器设置",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Text(
                text = "选择要连接的服务器",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            
            Column(
                modifier = Modifier.selectableGroup()
            ) {
                serverOptions.forEach { (name, url) ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (selectedServer == url),
                                onClick = { 
                                    selectedServer = url
                                    preferenceManager.saveSelectedServer(url)
                                    onServerChanged()
                                },
                                role = Role.RadioButton
                            )
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (selectedServer == url),
                            onClick = null
                        )
                        Column(
                            modifier = Modifier.padding(start = 16.dp)
                        ) {
                            Text(
                                text = name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = url,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // API密钥设置
            Text(
                text = "API密钥设置",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Text(
                text = "设置用于发表评论的API密钥",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            OutlinedTextField(
                value = apiKey,
                onValueChange = { apiKey = it },
                label = { Text("API密钥") },
                placeholder = { Text("请输入您的API密钥") },
                visualTransformation = if (showApiKey) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { showApiKey = !showApiKey }) {
                        Icon(
                            imageVector = if (showApiKey) Icons.Default.Info else Icons.Default.Lock,
                            contentDescription = if (showApiKey) "隐藏密钥" else "显示密钥"
                        )
                    }
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        if (apiKey.isNotBlank()) {
                            preferenceManager.saveApiKey(apiKey)
                            showApiKeySuccess = true
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("保存密钥")
                }
                
                OutlinedButton(
                    onClick = {
                        apiKey = ""
                        preferenceManager.clearApiKey()
                        showApiKeySuccess = false
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("清除密钥")
                }
            }
            
            if (showApiKeySuccess) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "✓ API密钥已保存",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // 字体大小设置
            Text(
                text = "字体大小设置",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            // 字体大小调整器
            FontSizeAdjusterInSettings()
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // 自动后台更新设置
            Text(
                text = "自动后台更新",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            AutoUpdateSettings(preferenceManager = preferenceManager)
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // 应用更新设置
            Text(
                text = "应用更新",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            AppUpdateSettings(
                 preferenceManager = preferenceManager,
                 coroutineScope = coroutineScope
             )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "注意",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "更改服务器后，应用需要重新启动才能生效。",
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AppUpdateSettings(
    preferenceManager: PreferenceManager,
    coroutineScope: CoroutineScope
) {
    val updateManager: UpdateManager = hiltViewModel()
    var isChecking by remember { mutableStateOf(false) }
    var showUpdateDialog by remember { mutableStateOf(false) }
    var updateInfo by remember { mutableStateOf<com.halo.blog.data.model.UpdateInfo?>(null) }
    var checkResult by remember { mutableStateOf<String?>(null) }
    
    // 检查是否有保存的更新信息
     LaunchedEffect(Unit) {
         if (preferenceManager.hasNewVersion()) {
             val versionNumber = preferenceManager.getNewVersionNumber()
             val downloadUrl = preferenceManager.getNewVersionDownloadUrl()
             if (versionNumber != null && downloadUrl != null) {
                 updateInfo = UpdateInfo(
                     version = versionNumber,
                     versionName = versionNumber,
                     description = null,
                     downloadUrl = downloadUrl,
                     fileSize = 0L,
                     publishTime = ""
                 )
                 showUpdateDialog = true
             }
         }
     }
    
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "检查应用是否有新版本可用",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Button(
            onClick = {
                isChecking = true
                checkResult = null
                updateManager.checkForUpdate()
                 coroutineScope.launch {
                     updateManager.updateState.collect { state ->
                         when (state) {
                             is UpdateManager.UpdateState.Checking -> {
                                 isChecking = true
                                 checkResult = null
                             }
                             is UpdateManager.UpdateState.UpdateAvailable -> {
                                 isChecking = false
                                 updateInfo = state.updateInfo
                                 preferenceManager.setHasNewVersion(true)
                                 preferenceManager.setNewVersionInfo(state.updateInfo.version, state.updateInfo.downloadUrl)
                                 showUpdateDialog = true
                                 checkResult = "发现新版本 ${state.updateInfo.version}（当前版本：${com.halo.blog.BuildConfig.VERSION_NAME}）"
                             }
                             is UpdateManager.UpdateState.NoUpdate -> {
                                 isChecking = false
                                 checkResult = "当前已是最新版本:本地${com.halo.blog.BuildConfig.VERSION_NAME} 远程${state.remoteVersion ?: "未知"}"
                             }
                             is UpdateManager.UpdateState.Error -> {
                                 isChecking = false
                                 checkResult = "检查更新失败: ${state.message}"
                             }
                             else -> {
                                 isChecking = false
                             }
                         }
                     }
                 }
            },
            enabled = !isChecking,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (isChecking) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(16.dp),
                        strokeWidth = 2.dp
                    )
                    Text("检查中...")
                }
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Text("检查更新")
                }
            }
        }
        
        // 显示检查结果
        checkResult?.let { result ->
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = if (result.contains("失败")) {
                        MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
                    } else if (result.contains("新版本")) {
                        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                    } else {
                        MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                    }
                )
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = if (result.contains("失败")) {
                            MaterialTheme.colorScheme.error
                        } else if (result.contains("新版本")) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                        },
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = result,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                }
            }
        }
    }
    
    // 显示更新对话框
    if (showUpdateDialog && updateInfo != null) {
        UpdateDialog(
            updateInfo = updateInfo!!,
            onDownload = {
                // 这里可以添加下载逻辑
                showUpdateDialog = false
                preferenceManager.setHasNewVersion(false)
                preferenceManager.clearNewVersionInfo()
            },
            onDismiss = {
                showUpdateDialog = false
                preferenceManager.setHasNewVersion(false)
                preferenceManager.clearNewVersionInfo()
            }
        )
    }
}

@Composable
fun AutoUpdateSettings(preferenceManager: PreferenceManager) {
    val context = LocalContext.current
    val autoUpdateManager = remember { AutoUpdateManager(context) }
    
    var isAutoUpdateEnabled by remember { 
        mutableStateOf(preferenceManager.isAutoUpdateEnabled()) 
    }
    
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "开启后，应用将每小时自动在后台更新文章内容",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "自动后台更新",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = if (isAutoUpdateEnabled) "已开启 - 每小时更新一次" else "已关闭",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
            
            Switch(
                checked = isAutoUpdateEnabled,
                onCheckedChange = { enabled ->
                    isAutoUpdateEnabled = enabled
                    preferenceManager.setAutoUpdateEnabled(enabled)
                    
                    // 根据开关状态启动或停止自动更新任务
                    if (enabled) {
                        autoUpdateManager.startAutoUpdate()
                    } else {
                        autoUpdateManager.stopAutoUpdate()
                    }
                }
            )
        }
        
        if (isAutoUpdateEnabled) {
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                )
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "后台更新将在应用未使用时进行，不会影响正常使用",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                }
            }
        }
    }
}

@Composable
fun FontSizeAdjusterInSettings() {
    val context = LocalContext.current
    val sharedPrefs = remember { context.getSharedPreferences("font_settings", android.content.Context.MODE_PRIVATE) }
    
    // 字体大小范围：14px - 40px，默认35px
    var fontSize by remember { 
        mutableFloatStateOf(sharedPrefs.getFloat("font_size", 35f)) 
    }
    
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "调整文章字体大小",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "A",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            
            Slider(
                value = fontSize,
                onValueChange = { newSize ->
                    fontSize = newSize
                    // 保存到SharedPreferences
                    sharedPrefs.edit().putFloat("font_size", newSize).apply()
                    // 触发HtmlTextContent重新渲染
                    com.halo.blog.utils.FontSizeManager.updateFontSize(newSize)
                },
                valueRange = 14f..40f,
                steps = 25, // 26个步长，每步1px
                modifier = Modifier.weight(1f)
            )
            
            Text(
                text = "A",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            
            Text(
                text = "${fontSize.toInt()}px",
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                modifier = Modifier.width(35.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // 预览文字
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = "预览",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Text(
                    text = "做最好的自己",
                    fontSize = fontSize.sp,
                    lineHeight = (fontSize * 1.6f).sp,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }
}