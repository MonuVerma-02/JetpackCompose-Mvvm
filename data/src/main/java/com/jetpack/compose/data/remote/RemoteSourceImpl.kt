package com.jetpack.compose.data.remote

import com.jetpack.compose.data.api.ApiService
import com.jetpack.compose.data.model.Animal
import javax.inject.Inject

class RemoteSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteSource {
    override suspend fun getDogs(): List<Animal> {
        return apiService.getDogList()
    }

    override suspend fun getCats(): List<Animal> {
        return apiService.getCatList()
    }

    override suspend fun getRabbit(): List<Animal> {
        return apiService.getRabbitList()
    }
}