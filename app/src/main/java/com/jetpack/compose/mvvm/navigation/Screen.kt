package com.jetpack.compose.mvvm.navigation

sealed class Screen(val route: String) {
    object Splash : Screen(route = "splash")
    object Home : Screen(route = "home")
    object Details : Screen(route = "details")
}
