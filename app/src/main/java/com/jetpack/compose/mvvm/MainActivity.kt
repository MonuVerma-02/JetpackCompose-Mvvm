package com.jetpack.compose.mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jetpack.compose.mvvm.navigation.NavGraphs
import com.jetpack.compose.mvvm.ui.theme.AnimalParkTheme
import com.jetpack.compose.mvvm.ui.theme.background
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalParkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = background
                ) {
                    val navController = rememberNavController()
                    NavGraphs(navController = navController)
                }
            }
        }
    }
}