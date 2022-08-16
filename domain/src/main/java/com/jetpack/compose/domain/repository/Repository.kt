package com.jetpack.compose.domain.repository

import com.jetpack.compose.domain.utils.Result
import com.jetpack.compose.domain.model.Animal
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getDogList(): Flow<Result<List<Animal>>>

    suspend fun getCatList(): Flow<Result<List<Animal>>>

    suspend fun getRabbitList(): Flow<Result<List<Animal>>>
}