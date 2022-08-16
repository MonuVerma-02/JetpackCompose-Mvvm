package com.jetpack.compose.mvvm.ui.screens.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.jetpack.compose.mvvm.navigation.Screen
import com.jetpack.compose.mvvm.ui.theme.background
import com.jetpack.compose.mvvm.ui.screens.utils.Constants
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = Constants.ANIM_TIME_DURATION
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(Constants.SPLASH_SCREEN_DELAY_TIME)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }

    SplashScreenComponent(anim = alphaAnim.value)
}

@Composable
fun SplashScreenComponent(anim: Float) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = background,
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SplashScreenImage(anim = anim)
        }
    }
}

@Composable
@Preview
fun SplashScreenPreview() {
    SplashScreen(navController = NavHostController(LocalContext.current))
}