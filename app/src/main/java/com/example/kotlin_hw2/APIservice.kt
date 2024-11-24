package com.example.kotlin_hw2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIservice {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://bluesky-api-by-jack-dorsey.p.rapidapi.com/get_post_thread?post=at%3A%2F%2Fdid%3Aplc%3Az72i7hdynmk6r22z27h6tvur%2Fapp.bsky.feed.post%2F3jzwwq3yf4n2k")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val imgAPI: ImgAPI = retrofit.create(ImgAPI::class.java)
}