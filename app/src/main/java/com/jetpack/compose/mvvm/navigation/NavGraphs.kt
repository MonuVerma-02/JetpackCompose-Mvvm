package com.jetpack.compose.mvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jetpack.compose.mvvm.ui.screens.details.DetailsScreen
import com.jetpack.compose.mvvm.ui.screens.home.HomeScreen
import com.jetpack.compose.mvvm.ui.screens.splash.SplashScreen
import com.jetpack.compose.mvvm.ui.screens.utils.Constants
import com.jetpack.compose.presentation.model.Animal

@Composable
fun NavGraphs(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(
            route = Screen.Splash.route
        ) {
            SplashScreen(navController = navController)
        }

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Details.route
        ) {
            //Fetching the argument which has been passed
            var animal =
                navController.previousBackStackEntry?.arguments?.getParcelable<Animal>(Constants.ANIMAL_Details_KEY)
            animal?.let {
                DetailsScreen(animal = it, navController = navController)
            }
        }
    }
}