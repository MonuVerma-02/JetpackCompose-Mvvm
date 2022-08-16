package com.jetpack.compose.mvvm.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.mvvm.R

@Composable
fun SplashScreenImage(anim: Float) {
    Card(
        shape = CircleShape,
        modifier = Modifier
            .padding(8.dp)
            .size(128.dp),
        elevation = 4.dp,
        backgroundColor = Color.White
    ) {
        Image(
            modifier = Modifier
                .padding(12.dp)
                .size(128.dp)
                .alpha(anim),
            painter = painterResource(id = R.drawable.splash_icon),
            contentScale = ContentScale.Crop,
            contentDescription = "logo"
        )
    }
}

@Composable
@Preview
fun SplashScreenImagePreview() {
    SplashScreenImage(.5f)
}