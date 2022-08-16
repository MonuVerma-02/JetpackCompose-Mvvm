package com.jetpack.compose.presentation.viewmodel

import com.jetpack.compose.presentation.model.Animal
import com.jetpack.compose.presentation.utils.empty

data class AnimalState(
    val animals: List<Animal> = emptyList(),
    val isLoading: Boolean = true,
    val error: String = String.empty()
)