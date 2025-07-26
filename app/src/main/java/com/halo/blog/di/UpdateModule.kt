package com.halo.blog.di

import com.halo.blog.data.api.LoggingGsonConverterFactory
import com.halo.blog.data.api.UpdateApiService
import com.halo.blog.utils.UpdateChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UpdateRetrofit

@Module
@InstallIn(SingletonComponent::class)
object UpdateModule {
    
    @Provides
    @Singleton
    @UpdateRetrofit
    fun provideUpdateRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/") // GitHub API基础URL
            .client(okHttpClient)
            .addConverterFactory(LoggingGsonConverterFactory.create())
            .build()
    }
    
    @Provides
    @Singleton
    fun provideUpdateApiService(@UpdateRetrofit updateRetrofit: Retrofit): UpdateApiService {
        return updateRetrofit.create(UpdateApiService::class.java)
    }
    
    @Provides
    @Singleton
    fun provideUpdateChecker(updateApiService: UpdateApiService): UpdateChecker {
        return UpdateChecker(updateApiService)
    }
}