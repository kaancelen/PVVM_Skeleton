package com.kaancelen.pvvm.network

import com.kaancelen.pvvm.util.Sage
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class OkHttpService {
    companion object {
        const val timeout = 40L
    }

    fun newOkHttpClient() : OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(timeout, TimeUnit.SECONDS)
        builder.connectTimeout(timeout, TimeUnit.SECONDS)
        builder.writeTimeout(timeout, TimeUnit.SECONDS)

        if(Sage.debug) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.interceptors().add(interceptor)
        }

        builder.interceptors().add(InterceptorService())

        val cache = Cache(Sage.context.cacheDir, 10 * 1024 * 1024)
        builder.cache(cache)

        return builder.build()
    }
}