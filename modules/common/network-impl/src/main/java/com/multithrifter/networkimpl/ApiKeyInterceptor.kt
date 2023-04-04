package com.multithrifter.networkimpl

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class ApiKeyInterceptor @Inject constructor() : Interceptor {

    private companion object {
        const val HEADER_API_KEY = "api_key"
        const val API_KEY = "47bbcb7d7661bc7f24853803bb34cc07"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .header(HEADER_API_KEY, API_KEY)
            .build()

        return chain.proceed(request)
    }
}