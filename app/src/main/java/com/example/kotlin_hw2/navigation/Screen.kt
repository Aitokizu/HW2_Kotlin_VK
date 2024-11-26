package com.example.kotlin_hw2.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home_screen")
}