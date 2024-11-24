package com.example.kotlin_hw2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ImgViewModel : ViewModel() {
    var imgUrl by mutableStateOf("")
    var isLoading by mutableStateOf(true)

    fun loadImg(imgAPI: ImgAPI) {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = imgAPI.getImg()
                imgUrl = response.url
            } catch (e: Exception) {
                imgUrl = ""
            } finally {
                isLoading = false
            }
        }
    }
}