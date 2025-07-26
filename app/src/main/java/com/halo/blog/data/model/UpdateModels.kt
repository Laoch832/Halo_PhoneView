package com.halo.blog.data.model

import com.google.gson.annotations.SerializedName

/**
 * GitHub Release API 响应模型
 */
data class GitHubRelease(
    @SerializedName("tag_name")
    val tagName: String,
    
    @SerializedName("name")
    val name: String,
    
    @SerializedName("body")
    val body: String?,
    
    @SerializedName("published_at")
    val publishedAt: String,
    
    @SerializedName("assets")
    val assets: List<GitHubAsset>
)

/**
 * GitHub Release Asset 模型
 */
data class GitHubAsset(
    @SerializedName("name")
    val name: String,
    
    @SerializedName("browser_download_url")
    val browserDownloadUrl: String,
    
    @SerializedName("size")
    val size: Long
)

/**
 * 更新信息模型
 */
data class UpdateInfo(
    val version: String,
    val versionName: String,
    val description: String?,
    val downloadUrl: String,
    val fileSize: Long,
    val publishTime: String
) {
    companion object {
        fun fromGitHubRelease(release: GitHubRelease): UpdateInfo? {
            // 查找APK文件
            val apkAsset = release.assets.find { asset ->
                asset.name.endsWith(".apk", ignoreCase = true)
            } ?: return null
            
            return UpdateInfo(
                version = release.name,
                versionName = release.tagName,
                description = release.body,
                downloadUrl = apkAsset.browserDownloadUrl,
                fileSize = apkAsset.size,
                publishTime = release.publishedAt
            )
        }
    }
}