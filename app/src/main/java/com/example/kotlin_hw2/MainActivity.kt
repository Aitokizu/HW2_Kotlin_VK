package com.example.kotlin_hw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


data class Response(val url: String)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    Content()
                }
            }
        }
    }
}

@Composable
fun Content(imgViewModel: ImgViewModel = viewModel()) {
    val imgAPI = APIservice.imgAPI

    LaunchedEffect(Unit) {
        imgViewModel.loadImg(imgAPI)
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (imgViewModel.isLoading) {
            Text("Загрузка изображения...")
        } else {
            if (imgViewModel.imgUrl.isNotEmpty()) {
                Image(
                    painter = rememberAsyncImagePainter(model = imgViewModel.imgUrl),
                    contentDescription = "Изображение",
                    modifier = Modifier.size(200.dp)
                )
            } else {
                Text("Не удалось загрузить изображение.")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { imgViewModel.loadImg(imgAPI) }) {
            Text("Показать другое изображение")
        }
    }
}