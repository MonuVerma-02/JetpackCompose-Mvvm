package com.jetpack.compose.mvvm.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jetpack.compose.presentation.model.Animal

@Composable
fun DetailsScreen(animal: Animal = Animal(), navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        TitleBarContent(animal = animal, navController = navController)
        DetailsContent(animal = animal)
    }

}


