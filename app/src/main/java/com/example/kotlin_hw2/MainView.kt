package com.example.kotlin_hw2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull

class MainView {

    companion object {
        private val client = OkHttpClient()

        suspend fun remixArt(): String {
            val mediaType =
                "multipart/form-data; boundary=---011000010111000001101001".toMediaTypeOrNull()
            val body = RequestBody.create(
                mediaType,
                "-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"focusContent\"\r\n\r\ntrue\r\n-----011000010111000001101001--\r\n\r\n"
            )
            val request = Request.Builder()
                .url("https://ai-art-maker.p.rapidapi.com/remix-art")
                .post(body)
                .addHeader("Content-Type", "multipart/form-data; boundary=---011000010111000001101001")
                .build()

            return withContext(Dispatchers.IO) {
                try {
                    val response = client.newCall(request).execute()
                    if (response.isSuccessful) {
                        response.body?.string() ?: " "
                    } else {
                        "Error: ${response.code}"
                    }
                } catch (e: Exception) {
                    "Error: ${e.message}"
                }
            }
        }
    }
}