package com.jetpack.compose.domain.usecase

import com.jetpack.compose.domain.repository.Repository
import javax.inject.Inject

class GetRabbitUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke() =
        repository.getRabbitList()
}