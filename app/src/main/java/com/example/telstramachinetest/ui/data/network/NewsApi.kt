package com.example.telstramachinetest.ui.data.network

import com.example.telstramachinetest.ui.data.News
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NewsApi {

    @GET("facts.json")
    suspend fun getData(): Response<News>//LiveData<News>


    companion object {

        const val BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/"

        operator fun invoke(): NewsApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsApi::class.java)

        }
    }
}