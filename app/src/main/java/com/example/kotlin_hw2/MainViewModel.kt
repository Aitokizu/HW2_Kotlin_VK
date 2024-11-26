package com.example.kotlin_hw2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.kotlin_hw2.data.repo.Repo
import com.example.kotlin_hw2.model.UnsplashImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: Repo
) : ViewModel() {

    // Получаем данные из репозитория с использованием PagingData
    val images: Flow<PagingData<UnsplashImage>> = repo.getAllImages().cachedIn(viewModelScope)
}