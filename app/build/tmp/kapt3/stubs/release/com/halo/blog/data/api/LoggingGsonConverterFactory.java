package com.halo.blog.data.api;

import java.lang.System;

/**
 * 自定义Gson转换器工厂，用于记录JSON解析错误
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0003\u0015\u0016\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JE\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010J7\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/halo/blog/data/api/LoggingGsonConverterFactory;", "Lretrofit2/Converter$Factory;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "requestBodyConverter", "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "type", "Ljava/lang/reflect/Type;", "parameterAnnotations", "", "", "methodAnnotations", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "responseBodyConverter", "Lokhttp3/ResponseBody;", "annotations", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "Companion", "LoggingRequestBodyConverter", "LoggingResponseBodyConverter", "app_release"})
public final class LoggingGsonConverterFactory extends retrofit2.Converter.Factory {
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.halo.blog.data.api.LoggingGsonConverterFactory.Companion Companion = null;
    
    private LoggingGsonConverterFactory(com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public retrofit2.Converter<okhttp3.ResponseBody, ?> responseBodyConverter(@org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type, @org.jetbrains.annotations.NotNull()
    java.lang.annotation.Annotation[] annotations, @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public retrofit2.Converter<?, okhttp3.RequestBody> requestBodyConverter(@org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type, @org.jetbrains.annotations.NotNull()
    java.lang.annotation.Annotation[] parameterAnnotations, @org.jetbrains.annotations.NotNull()
    java.lang.annotation.Annotation[] methodAnnotations, @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    /**
     * 响应体转换器，记录JSON解析错误
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0016\u00a2\u0006\u0002\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/halo/blog/data/api/LoggingGsonConverterFactory$LoggingResponseBodyConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "adapter", "Lcom/google/gson/TypeAdapter;", "(Lcom/google/gson/TypeAdapter;)V", "convert", "value", "(Lokhttp3/ResponseBody;)Ljava/lang/Object;", "app_release"})
    static final class LoggingResponseBodyConverter<T extends java.lang.Object> implements retrofit2.Converter<okhttp3.ResponseBody, T> {
        private final com.google.gson.TypeAdapter<T> adapter = null;
        
        public LoggingResponseBodyConverter(@org.jetbrains.annotations.NotNull()
        com.google.gson.TypeAdapter<T> adapter) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
        @java.lang.Override()
        public T convert(@org.jetbrains.annotations.NotNull()
        okhttp3.ResponseBody value) {
            return null;
        }
    }
    
    /**
     * 请求体转换器，记录JSON序列化错误
     */
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/halo/blog/data/api/LoggingGsonConverterFactory$LoggingRequestBodyConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "adapter", "Lcom/google/gson/TypeAdapter;", "(Lcom/google/gson/TypeAdapter;)V", "convert", "value", "(Ljava/lang/Object;)Lokhttp3/RequestBody;", "app_release"})
    static final class LoggingRequestBodyConverter<T extends java.lang.Object> implements retrofit2.Converter<T, okhttp3.RequestBody> {
        private final com.google.gson.TypeAdapter<T> adapter = null;
        
        public LoggingRequestBodyConverter(@org.jetbrains.annotations.NotNull()
        com.google.gson.TypeAdapter<T> adapter) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.Throws(exceptionClasses = {java.io.IOException.class})
        @java.lang.Override()
        public okhttp3.RequestBody convert(T value) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/halo/blog/data/api/LoggingGsonConverterFactory$Companion;", "", "()V", "create", "Lcom/halo/blog/data/api/LoggingGsonConverterFactory;", "gson", "Lcom/google/gson/Gson;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.halo.blog.data.api.LoggingGsonConverterFactory create(@org.jetbrains.annotations.NotNull()
        com.google.gson.Gson gson) {
            return null;
        }
    }
}