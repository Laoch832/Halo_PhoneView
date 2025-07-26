package com.halo.blog.data.api

import com.halo.blog.data.model.GitHubRelease
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * 更新检查API服务
 */
interface UpdateApiService {
    
    /**
     * 获取最新版本信息
     * @param url 完整的API URL
     */
    @GET
    suspend fun getLatestRelease(@Url url: String): Response<GitHubRelease>
}