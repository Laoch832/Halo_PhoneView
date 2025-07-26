package com.halo.blog.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.halo.blog.data.repository.HaloRepository
import com.halo.blog.utils.LogUtils
import com.halo.blog.utils.PreferenceManager
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 自动后台更新工作类
 * 每小时执行一次，更新文章列表和缓存
 */
@HiltWorker
class AutoUpdateWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val repository: HaloRepository
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        return@withContext try {
            val preferenceManager = PreferenceManager(applicationContext)
            
            // 检查是否启用了自动更新
            if (!preferenceManager.isAutoUpdateEnabled()) {
                LogUtils.d("AutoUpdateWorker", "自动更新已禁用，跳过更新")
                return@withContext Result.success()
            }

            LogUtils.d("AutoUpdateWorker", "开始执行自动后台更新")

            // 更新文章列表
            try {
                repository.getPosts(page = 0, size = 20).collect { result ->
                    result.fold(
                        onSuccess = { postResponse ->
                            val posts = postResponse.items.map { com.halo.blog.data.model.PostItem.fromPost(it) }
                            if (posts.isNotEmpty()) {
                                preferenceManager.cachePostList(posts)
                                LogUtils.d("AutoUpdateWorker", "成功更新文章列表，数量: ${posts.size}")
                            } else {
                                LogUtils.w("AutoUpdateWorker", "获取到的文章列表为空")
                            }
                        },
                        onFailure = { exception ->
                            LogUtils.e("AutoUpdateWorker", "更新文章列表失败: ${exception.message}")
                        }
                    )
                }
            } catch (e: Exception) {
                LogUtils.e("AutoUpdateWorker", "更新文章列表失败: ${e.message}")
                // 不返回失败，继续尝试其他更新
            }

            // 可以在这里添加更多的后台更新逻辑
            // 比如更新热门文章、分类信息等

            LogUtils.d("AutoUpdateWorker", "自动后台更新完成")
            Result.success()
        } catch (e: Exception) {
            LogUtils.e("AutoUpdateWorker", "自动后台更新失败: ${e.message}")
            Result.retry()
        }
    }
}