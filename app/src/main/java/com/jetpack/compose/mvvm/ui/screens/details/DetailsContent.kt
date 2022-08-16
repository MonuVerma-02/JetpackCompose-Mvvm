package com.jetpack.compose.mvvm.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.jetpack.compose.presentation.model.Animal

@Composable
fun DetailsContent(animal: Animal) {
    Column {
        AnimalImage(image = animal.image)
        Spacer(modifier = Modifier.height(20.dp))
        AnimalBreeds(breeds = animal.breeds)
        Spacer(modifier = Modifier.height(20.dp))
        AnimalDescription(description = animal.description)
    }

}

@Composable
fun AnimalImage(image: String) {
    Column(
        modifier = Modifier
            .height(300.dp)
    ) {
        val model = ImageRequest.Builder(LocalContext.current)
            .data(image)
            .size(Size.ORIGINAL)
            .crossfade(true)
            .build()
        val painter = rememberAsyncImagePainter(model = model)

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }

}

@Composable
fun AnimalBreeds(breeds: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "Breeds",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = breeds,
            fontSize = 14.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.Gray
        )
    }
}

@Composable
fun AnimalDescription(description: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = "Description",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace
        )
        Text(
            modifier = Modifier
                .padding(8.dp),
            text = description,
            fontSize = 14.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.Gray
        )
    }
}

@Composable
@Preview
fun DetailsContentPreview() {
    val dummyAnimal = Animal(
        image = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/44365525/3/?bust=1554156953&width=1080",
        breeds = "Catahoula Leopard Dog Mix",
        description = "Meet Turbo: Tank and Turbo are two gorgeous Catahoula mix boys who love nothing more than running and playing."
    )
    DetailsContent(animal = dummyAnimal)
}