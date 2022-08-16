package com.jetpack.compose.mvvm.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.jetpack.compose.mvvm.navigation.Screen
import com.jetpack.compose.mvvm.ui.screens.utils.Constants
import com.jetpack.compose.presentation.model.Animal

@Composable
fun AnimalViewContent(animal: Animal, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp, start = 4.dp, end = 4.dp)
            .clickable {
                //pass animal object to Details Screen
                navController.currentBackStackEntry?.arguments?.putParcelable(
                    Constants.ANIMAL_Details_KEY,
                    animal
                )
                navController.navigate(Screen.Details.route)
            },
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.width(160.dp),
            horizontalAlignment = Alignment.Start
        ) {
            val model = ImageRequest.Builder(LocalContext.current)
                .data("${animal.image}")
                .size(Size.ORIGINAL)
                .crossfade(true)
                .build()
            val painter = rememberAsyncImagePainter(
                model = model
            )
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(160.dp),
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Text(
                    text = "${animal.name}",
                    fontSize = 14.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                )
            }
        }
    }
}

@Composable
@Preview
fun AnimalViewContentPreview() {
    val dummyAnimal = Animal(
        name = "Turbo",
        image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/44365525/3/?bust=1554156953&width=1080"
    )
    AnimalViewContent(
        animal = dummyAnimal,
        navController = NavHostController(LocalContext.current)
    )
}