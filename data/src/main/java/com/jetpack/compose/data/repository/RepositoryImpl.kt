package com.jetpack.compose.data.repository

import com.jetpack.compose.data.mapper.AnimalDomainMapper
import com.jetpack.compose.data.remote.RemoteSource
import com.jetpack.compose.domain.utils.Result
import com.jetpack.compose.domain.model.Animal
import com.jetpack.compose.domain.repository.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val remoteSource: RemoteSource
) : Repository {
    override suspend fun getDogList(): Flow<Result<List<Animal>>> = flow {
        emit(Result.Loading)
        try {
            val data = remoteSource.getDogs()
            if (data.isNotEmpty()) {
                emit(Result.Success(AnimalDomainMapper().toDomain(data)))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Unknown error"))
        }
    }.flowOn(dispatcher)

    override suspend fun getCatList(): Flow<Result<List<Animal>>> = flow {
        emit(Result.Loading)
        try {
            val data = remoteSource.getCats()
            if (data.isNotEmpty()) {
                emit(Result.Success(AnimalDomainMapper().toDomain(data)))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Unknown error"))
        }
    }.flowOn(dispatcher)

    override suspend fun getRabbitList(): Flow<Result<List<Animal>>> = flow {
        try {
            val data = remoteSource.getRabbit()
            if (data.isNotEmpty()) {
                emit(Result.Success(AnimalDomainMapper().toDomain(data)))
            }
        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Unknown error"))
        }
    }.flowOn(dispatcher)
}