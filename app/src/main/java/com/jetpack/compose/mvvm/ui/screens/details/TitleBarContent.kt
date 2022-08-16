package com.jetpack.compose.mvvm.ui.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jetpack.compose.mvvm.R
import com.jetpack.compose.presentation.model.Animal

@Composable
fun TitleBarContent(animal: Animal, navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TitleBarIcon(navController = navController)
        TitleBarMessage(animal = animal)
    }
}

@Composable
fun TitleBarIcon(navController: NavHostController) {
    IconButton(
        onClick = {
            navController.popBackStack()
        },
    ) {
        Icon(
            painter = painterResource(R.drawable.back_arrow_icon),
            contentDescription = "back",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun TitleBarMessage(animal: Animal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 25.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.padding(top = 5.dp),
            text = "${animal.name}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Composable
@Preview
fun TitleBarContentPreview() {
    val dummyAnimal = Animal(name = "Turbo")
    TitleBarContent(animal = dummyAnimal, navController = NavHostController(LocalContext.current))
}