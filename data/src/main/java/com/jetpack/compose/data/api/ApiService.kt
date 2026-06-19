package com.jetpack.compose.data.api

import com.jetpack.compose.data.model.Animal

import retrofit2.http.GET

interface ApiService {

    @GET("T0XWig/dogs")
    suspend fun getDogList(): List<Animal>

    @GET("8Txd6z/cats")
    suspend fun getCatList(): List<Animal>

    @GET("X4cUYO/rabbits")
    suspend fun getRabbitList(): List<Animal>
}