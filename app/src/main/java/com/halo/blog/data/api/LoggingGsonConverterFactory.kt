package com.halo.blog.data.api

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.TypeAdapter
import com.google.gson.reflect.TypeToken
import com.halo.blog.utils.LogUtils
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type

/**
 * 自定义Gson转换器工厂，用于记录JSON解析错误
 */
class LoggingGsonConverterFactory private constructor(
    private val gson: Gson
) : Converter.Factory() {

    companion object {
        fun create(gson: Gson = Gson()): LoggingGsonConverterFactory {
            return LoggingGsonConverterFactory(gson)
        }
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val adapter = gson.getAdapter(TypeToken.get(type))
        return LoggingResponseBodyConverter(adapter)
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<Annotation>,
        methodAnnotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        val adapter = gson.getAdapter(TypeToken.get(type))
        return LoggingRequestBodyConverter(adapter)
    }

    /**
     * 响应体转换器，记录JSON解析错误
     */
    private class LoggingResponseBodyConverter<T>(
        private val adapter: TypeAdapter<T>
    ) : Converter<ResponseBody, T> {

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): T? {
            val jsonString = value.string()
            
            return try {
                adapter.fromJson(jsonString)
            } catch (e: JsonSyntaxException) {
                LogUtils.logJsonError(jsonString, e)
                throw e
            } catch (e: Exception) {
                LogUtils.logJsonError(jsonString, e)
                throw e
            }
        }
    }

    /**
     * 请求体转换器，记录JSON序列化错误
     */
    private class LoggingRequestBodyConverter<T>(
        private val adapter: TypeAdapter<T>
    ) : Converter<T, RequestBody> {

        @Throws(IOException::class)
        override fun convert(value: T): RequestBody {
            return try {
                val jsonString = adapter.toJson(value)
                LogUtils.d("JSON", "请求JSON: $jsonString")
                RequestBody.create(
                    "application/json; charset=UTF-8".toMediaTypeOrNull(),
                    jsonString
                )
            } catch (e: Exception) {
                LogUtils.e("JSON", "JSON序列化错误: ${e.message}", e)
                throw e
            }
        }
    }
}