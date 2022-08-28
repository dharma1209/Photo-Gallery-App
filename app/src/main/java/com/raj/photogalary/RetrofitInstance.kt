package com.raj.photogalary

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//url = "https://pixabay.com/api/?key=13052447-1909a7a8dc154dcc976dbbbac&q=yellow+flowers&image_type=photo&pretty=true"
const val BASE_URL = "https://pixabay.com/"
object RetrofitInstance {

//    private val client = OkHttpClient.Builder().apply {
//        addInterceptor(MyInterceptor())
//    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}