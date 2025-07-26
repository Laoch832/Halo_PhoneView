package com.halo.blog.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.halo.blog.BuildConfig
import com.halo.blog.ui.screen.HomeScreen
import com.halo.blog.ui.screen.PostDetailScreen
import com.halo.blog.ui.screen.SearchScreen
import com.halo.blog.ui.screen.CategoryScreen
import com.halo.blog.ui.screen.TagScreen
import com.halo.blog.ui.screen.ServerSelectionScreen
import com.halo.blog.ui.screen.SettingsScreen
import com.halo.blog.ui.viewmodel.SearchViewModel
import com.halo.blog.ui.viewmodel.CommentViewModel
import com.halo.blog.utils.PreferenceManager
import com.halo.blog.utils.UpdateManager
import com.halo.blog.ui.components.UpdateDialog
import com.halo.blog.data.model.UpdateInfo
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

sealed class Screen(val route: String) {
    object ServerSelection : Screen("server_selection")
    object Home : Screen("home")
    object PostDetail : Screen("post_detail/{postName}") {
        fun createRoute(postName: String) = "post_detail/$postName"
    }
    object Search : Screen("search")
    object Category : Screen("category/{categoryName}") {
        fun createRoute(categoryName: String) = "category/$categoryName"
    }
    object Tag : Screen("tag/{tagName}") {
        fun createRoute(tagName: String) = "tag/$tagName"
    }
    object Settings : Screen("settings")
}

@Composable
fun HaloBlogNavigation(
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    val preferenceManager = remember { PreferenceManager(context) }
    val updateManager: UpdateManager = hiltViewModel()
    
    // 监听更新状态
    val updateState by updateManager.updateState.collectAsStateWithLifecycle()
    var showUpdateDialog by remember { mutableStateOf(false) }
    var currentUpdateInfo by remember { mutableStateOf<UpdateInfo?>(null) }
    
    // 在应用启动时检查是否有保存的新版本信息，并主动检查更新
    LaunchedEffect(Unit) {
        // 首先检查是否有保存的新版本信息
        if (preferenceManager.hasNewVersion()) {
            val versionNumber = preferenceManager.getNewVersionNumber()
            val downloadUrl = preferenceManager.getNewVersionDownloadUrl()
            if (versionNumber != null && downloadUrl != null) {
                currentUpdateInfo = UpdateInfo(
                    version = versionNumber,
                    versionName = versionNumber,
                    description = "新版本可用",
                    downloadUrl = downloadUrl,
                    fileSize = 0L,
                    publishTime = ""
                )
                showUpdateDialog = true
            }
        } else {
            // 如果没有保存的版本信息，主动检查更新
            updateManager.checkForUpdate()
        }
    }
    
    // 处理更新状态变化
    LaunchedEffect(updateState) {
        when (val state = updateState) {
            is UpdateManager.UpdateState.UpdateAvailable -> {
                currentUpdateInfo = state.updateInfo
                showUpdateDialog = true
            }
            is UpdateManager.UpdateState.DownloadCompleted -> {
                // 下载完成后不立即关闭对话框，让用户看到完成状态
                // 对话框会在用户点击关闭或安装完成后自动关闭
            }
            else -> {
                // 其他状态不需要特殊处理
            }
        }
    }
    
    // 确定起始目的地
    val startDestination = if (BuildConfig.DEBUG && 
        (preferenceManager.isFirstLaunch() || preferenceManager.getSelectedServer() == null)) {
        Screen.ServerSelection.route
    } else {
        Screen.Home.route
    }
    
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.ServerSelection.route) {
            ServerSelectionScreen(
                onServerSelected = { serverUrl ->
                    preferenceManager.saveSelectedServer(serverUrl)
                    preferenceManager.markAppLaunched()
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.ServerSelection.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onPostClick = { postName ->
                    navController.navigate(Screen.PostDetail.createRoute(postName))
                },
                onSearchClick = {
                    navController.navigate(Screen.Search.route)
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }
        
        composable(Screen.PostDetail.route) { backStackEntry ->
            val postName = backStackEntry.arguments?.getString("postName") ?: ""
            val commentViewModel: CommentViewModel = hiltViewModel()
            PostDetailScreen(
                postName = postName,
                onBackClick = {
                    navController.popBackStack()
                },
                onCategoryClick = { categoryName ->
                    navController.navigate(Screen.Category.createRoute(categoryName))
                },
                onTagClick = { tagName ->
                    navController.navigate(Screen.Tag.createRoute(tagName))
                },
                commentViewModel = commentViewModel
            )
        }
        
        composable(Screen.Search.route) {
            val searchViewModel: SearchViewModel = hiltViewModel()
            SearchScreen(
                searchViewModel = searchViewModel,
                onBackClick = {
                    navController.popBackStack()
                },
                onPostClick = { postName ->
                    navController.navigate(Screen.PostDetail.createRoute(postName))
                },
                onCategoryClick = { categoryName ->
                    navController.navigate(Screen.Category.createRoute(categoryName))
                },
                onTagClick = { tagName ->
                    navController.navigate(Screen.Tag.createRoute(tagName))
                }
            )
        }
        
        composable(Screen.Category.route) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName") ?: ""
            CategoryScreen(
                categoryName = categoryName,
                onBackClick = {
                    navController.popBackStack()
                },
                onPostClick = { postName ->
                    navController.navigate(Screen.PostDetail.createRoute(postName))
                }
            )
        }
        
        composable(Screen.Tag.route) { backStackEntry ->
            val tagName = backStackEntry.arguments?.getString("tagName") ?: ""
            TagScreen(
                tagName = tagName,
                onBackClick = {
                    navController.popBackStack()
                },
                onPostClick = { postName ->
                    navController.navigate(Screen.PostDetail.createRoute(postName))
                }
            )
        }
        
        composable(Screen.Settings.route) {
            SettingsScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onServerChanged = {
                    // 服务器更改后的处理逻辑
                }
            )
        }
    }
    
    // 更新对话框
    if (showUpdateDialog && currentUpdateInfo != null) {
        UpdateDialog(
            updateInfo = currentUpdateInfo!!,
            onDownload = {
                 updateManager.startDownload(currentUpdateInfo!!)
             },
            onDismiss = {
                 showUpdateDialog = false
                 updateManager.resetState()
                 // 清除保存的新版本信息
                 preferenceManager.clearNewVersionInfo()
             },
            downloadStatus = when (val state = updateState) {
                 is UpdateManager.UpdateState.Downloading -> 
                     com.halo.blog.utils.ApkDownloadManager.DownloadStatus.Started(state.downloadId)
                 is UpdateManager.UpdateState.DownloadCompleted -> 
                     com.halo.blog.utils.ApkDownloadManager.DownloadStatus.Completed(state.filePath)
                 is UpdateManager.UpdateState.DownloadFailed -> 
                     com.halo.blog.utils.ApkDownloadManager.DownloadStatus.Failed(state.error)
                 else -> null
             }
        )
    }
}