package com.example.kotlin_hw2.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlin_hw2.util.Constants.UNSPLASH_REMOTE_KEYS_TABLE

@Entity(tableName = UNSPLASH_REMOTE_KEYS_TABLE) //TO STORE PREV AND NEXT
data class UnsplashRemoteKeys(
    @PrimaryKey
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
) {
}