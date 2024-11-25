package com.example.kotlin_hw2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlin_hw2.ui.theme.Kotlin_hw2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_hw2Theme {
                ImageGridWithAddButton()
            }
        }
    }
}

@Composable
fun ImageGridWithAddButton() {
    // Состояние списка изображений
    var imageList by remember { mutableStateOf(initialImageList.toMutableList()) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Сетка изображений
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(imageList) { imageRes ->
                ImageCard(imageRes = imageRes)
            }
        }

        // FloatingActionButton для добавления нового изображения
        FloatingActionButton(
            onClick = {
                // Добавляем новое изображение в список
                val newImageRes = R.drawable.ic_launcher_background
                imageList = (imageList + newImageRes).toMutableList()
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text("+") // Кнопка с текстом "+"
        }
    }
}

@Composable
fun ImageCard(imageRes: Int) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

// Начальный список изображений
private val initialImageList = listOf(
    R.drawable.ic_launcher_background,
    R.drawable.ic_launcher_foreground,
    R.drawable.ic_launcher_background
)