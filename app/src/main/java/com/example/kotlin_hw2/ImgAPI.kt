package com.example.kotlin_hw2

import retrofit2.http.GET


interface ImgAPI {
    @GET("img")
    suspend fun getImg(): ImgResponse
}