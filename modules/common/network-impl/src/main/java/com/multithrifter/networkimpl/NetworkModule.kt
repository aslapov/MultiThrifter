package com.multithrifter.networkimpl

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
internal class NetworkModule {

    private companion object {
        const val HOST_NAME = "api.currencybeacon.com"
        const val BASE_URL = "https://$HOST_NAME/v1/"
    }

    private val kotlinXSerialization = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        encodeDefaults = true
    }

    @NetworkScope
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(kotlinXSerialization.asConverterFactory(contentType))
            .build()
    }

    @NetworkScope
    @Provides
    fun provideOkHttpClient(
        apiKeyInterceptor: ApiKeyInterceptor,
    ): OkHttpClient {
        val loggingInterceptor = ConsoleLogger().takeIf { BuildConfig.DEBUG }

        return OkHttpClient
            .Builder().apply {
                loggingInterceptor?.let { addInterceptor(HttpLoggingInterceptor(it)) }
                addInterceptor(apiKeyInterceptor)
            }
            .build()
    }
}