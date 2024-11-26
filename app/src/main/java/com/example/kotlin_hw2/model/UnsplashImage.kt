package com.example.kotlin_hw2.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_hw2.model.Urls
import com.example.kotlin_hw2.util.Constants.UNSPLASH_IMAGE_TABLE

@Entity(tableName = UNSPLASH_IMAGE_TABLE )
data class UnsplashImage( //database
    @PrimaryKey() //for diff values for each image
    val id: String,
    @Embedded //for nested fields
    val urls: Urls,
)
