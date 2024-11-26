package com.example.kotlin_hw2.data.remote

import com.example.kotlin_hw2.BuildConfig
import com.example.kotlin_hw2.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("/photos")
    suspend fun getAllImages(
        @Query("client_id") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): List<UnsplashImage>

}