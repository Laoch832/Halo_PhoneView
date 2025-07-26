package com.halo.blog.data.api

import android.content.Context
import com.halo.blog.BuildConfig
import com.halo.blog.data.api.LoggingGsonConverterFactory
import com.halo.blog.utils.LogUtils
import com.halo.blog.utils.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    @Provides
    @Singleton
    fun provideAuthInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            
            // 从SharedPreferences或其他地方获取认证信息
            // 这里先使用示例配置，实际使用时需要从设置中获取
            val token = "" // 用户设置的Personal Access Token
            
            val newRequest = if (token.isNotEmpty()) {
                originalRequest.newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
            } else {
                originalRequest
            }
            
            // 记录请求信息
            val startTime = System.currentTimeMillis()
            LogUtils.logNetworkRequest(
                url = newRequest.url.toString(),
                method = newRequest.method,
                headers = newRequest.headers.toMap()
            )
            
            try {
                val response = chain.proceed(newRequest)
                val responseTime = System.currentTimeMillis() - startTime
                
                LogUtils.logNetworkResponse(
                    url = newRequest.url.toString(),
                    code = response.code,
                    message = response.message,
                    responseTime = responseTime
                )
                
                if (!response.isSuccessful) {
                    LogUtils.w("Network", "请求失败: ${response.code} - ${response.message}")
                }
                
                response
            } catch (e: Exception) {
                LogUtils.logNetworkError(newRequest.url.toString(), e)
                throw e
            }
        }
    }
    
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }
    
    @Provides
    @Singleton
    fun provideOkHttpClient(
        authInterceptor: Interceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
    
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        preferenceManager: PreferenceManager
    ): Retrofit {
        val baseUrl = preferenceManager.getSelectedServer() ?: "https://demo.halo.run/"
        val finalUrl = if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/"
        
        LogUtils.i("Network", "初始化Retrofit，基础URL: $finalUrl")
        
        return Retrofit.Builder()
            .baseUrl(finalUrl)
            .client(okHttpClient)
            .addConverterFactory(LoggingGsonConverterFactory.create())
            .build()
    }
    
    @Provides
    @Singleton
    fun provideHaloApiService(retrofit: Retrofit): HaloApiService {
        return retrofit.create(HaloApiService::class.java)
    }
    
    @Provides
    @Singleton
    fun providePreferenceManager(@ApplicationContext context: Context): PreferenceManager {
        return PreferenceManager(context)
    }
    

}