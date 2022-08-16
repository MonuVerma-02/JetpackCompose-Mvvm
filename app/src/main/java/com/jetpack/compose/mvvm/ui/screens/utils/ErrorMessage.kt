package com.jetpack.compose.mvvm.ui.screens.utils

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jetpack.compose.presentation.viewmodel.AnimalState
import com.jetpack.compose.presentation.viewmodel.HomeViewModel

@Composable
fun ErrorMessage(state: AnimalState) {
    val animals = state.animals
    val error = state.error

    val connection by connectivityState()
    val isConnected = connection === ConnectionState.Available

    if (isConnected && animals.isEmpty() && error.isNotEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = Color.Red,
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                text = error
            )
        }
    }
}