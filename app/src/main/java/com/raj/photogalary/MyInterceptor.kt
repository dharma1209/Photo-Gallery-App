package com.raj.photogalary

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MyInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
            .newBuilder()
            .addHeader("Content-Type","application/json")
            .addHeader("Authorization","563492ad6f917000010000018adab5bcf82e4f74a20d8480bdcab28f")
            .build()
        return chain.proceed(request)
    }
}