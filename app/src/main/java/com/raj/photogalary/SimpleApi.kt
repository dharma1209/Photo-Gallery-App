package com.raj.photogalary

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

//url = "https://pixabay.com/api/?key=13052447-1909a7a8dc154dcc976dbbbac&q=yellow+flowers&image_type=photo&pretty=true"
interface SimpleApi{

    @GET("api/?key=13052447-1909a7a8dc154dcc976dbbbac")
    fun getPhotos(@Query("page")page: Int, @Query("per_page") per_page:Int): Call<PhotoResponse>

    @GET("api/?key=13052447-1909a7a8dc154dcc976dbbbac")
    fun searchPhotos(@Query("per_page")per_page: Int,@Query("q") query:String): Call<PhotoResponse>
}
