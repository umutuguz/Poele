package com.umut.poele.data.source.remote

import okhttp3.Interceptor
import okhttp3.Response
class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newUrl = originalRequest.url
            .newBuilder()
            .addQueryParameter(
                "apiKey",
//                "8f7c0254decd4b238ed7ace07805087a"
//            "39ceaf71a8ce46e28db813bc0c32bad4"
            "531f4b20271d4c4aab697d63685dad9f"
            )
            .build()

        val request = originalRequest.newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(request)
    }
}
