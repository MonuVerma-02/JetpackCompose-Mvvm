package com.jetpack.compose.mvvm.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jetpack.compose.mvvm.ui.screens.utils.*
import com.jetpack.compose.presentation.model.Animal
import com.jetpack.compose.presentation.viewmodel.AnimalState
import com.jetpack.compose.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val dogState = viewModel.dogState.collectAsState()
    val catState = viewModel.catState.collectAsState()
    val rabbitState = viewModel.rabbitState.collectAsState()

    val connection by connectivityState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        Title()
        Spacer(modifier = Modifier.height(30.dp))
        AnimalList(text = "Dogs", state = dogState, navController = navController)
        Spacer(modifier = Modifier.height(30.dp))
        AnimalList(text = "Cats", state = catState, navController = navController)
        Spacer(modifier = Modifier.height(30.dp))
        AnimalList(text = "Rabbits", state = rabbitState, navController = navController)
        ConnectivityStatus(connection = connection, onRefresh = { viewModel.refresh() })
    }
}

@Composable
fun Title() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Animal Park",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
        )
    }
}

@Composable
fun AnimalList(
    text: String,
    state: State<AnimalState>,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(start = 8.dp),
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace
        )

        ProgressBar(isDisplayed = state.value.isLoading)

        ErrorMessage(state = state.value)

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            content = {
                val dogs: List<Animal> = state.value.animals
                items(dogs.size) { i ->
                    val dog = state.value.animals[i]

                    AnimalViewContent(animal = dog, navController = navController)
                }
            }
        )
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(navController = NavHostController(LocalContext.current))
}