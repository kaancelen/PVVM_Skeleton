package com.kaancelen.pvvm.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService(private val baseUrl: String, private val okHttpService: OkHttpService) {

    fun newRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpService.newOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}