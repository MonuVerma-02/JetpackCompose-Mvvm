package com.jetpack.compose.mvvm.ui.screens.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jetpack.compose.mvvm.ui.theme.green
import com.jetpack.compose.mvvm.ui.theme.red
import com.jetpack.compose.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.delay

@Composable
fun ConnectivityStatus(
    connection: ConnectionState,
    onRefresh: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val updatedOnRefresh = rememberUpdatedState(onRefresh)
    val isConnected = connection === ConnectionState.Available
    var visibility by remember { mutableStateOf(false) }

    val dogState = viewModel.dogState.collectAsState()
    val catState = viewModel.catState.collectAsState()
    val rabbitState = viewModel.rabbitState.collectAsState()

    AnimatedVisibility(
        visible = visibility,
        enter = expandVertically(),
        exit = shrinkVertically()
    ) {
        ConnectivityStatusBox(isConnected = isConnected)
    }

    LaunchedEffect(isConnected) {
        if (!isConnected) {
            visibility = true
        } else {
            delay(2000)
            visibility = false

            if (dogState.value.animals.isEmpty()
                && catState.value.animals.isEmpty()
                && rabbitState.value.animals.isEmpty()
            ) {
                updatedOnRefresh.value.invoke()
            }
        }
    }
}

@Composable
fun ConnectivityStatusBox(isConnected: Boolean) {
    val backgroundColor by animateColorAsState(if (isConnected) green else red)
    val message = if (isConnected) "Back Online!" else "No Internet Connection!"
    val iconResource = if (isConnected) {
        android.R.drawable.ic_lock_idle_charging
    } else {
        android.R.drawable.ic_lock_idle_low_battery
    }

    Box(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = "Connectivity Icon",
                tint = Color.White
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                message,
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}