package com.jetpack.compose.domain.usecase

import com.jetpack.compose.domain.utils.Result
import com.jetpack.compose.domain.model.Animal
import com.jetpack.compose.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDogUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(): Flow<Result<List<Animal>>> =
        repository.getDogList()
}