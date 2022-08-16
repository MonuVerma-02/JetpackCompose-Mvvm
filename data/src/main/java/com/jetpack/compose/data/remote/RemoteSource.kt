package com.jetpack.compose.data.remote

import com.jetpack.compose.data.model.Animal

interface RemoteSource {
    suspend fun getDogs(): List<Animal>
    suspend fun getCats(): List<Animal>
    suspend fun getRabbit(): List<Animal>
}