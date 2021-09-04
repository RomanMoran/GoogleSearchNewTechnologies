package com.example.googlesearchnewtechnologies.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class GoogleSearchInterceptor(
    private val cx: String,
    private val apiKey: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val httpUrl = original.url.newBuilder()
            .addQueryParameter("cx", cx)
            .addQueryParameter("key", apiKey)
            .build()

        val requestBuilder: Request.Builder = original.newBuilder().url(httpUrl)

        return chain.proceed(requestBuilder.build())
    }

}