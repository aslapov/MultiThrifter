package com.multithrifter.networkimpl

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

internal class ApiKeyInterceptor @Inject constructor() : Interceptor {

    private companion object {
        const val API_KEY_QUERY_PARAMETER = "api_key"
        const val API_KEY = "47bbcb7d7661bc7f24853803bb34cc07"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY_PARAMETER, API_KEY)
            .build()
        request = request.newBuilder().url(url).build()

        return chain.proceed(request)
    }
}