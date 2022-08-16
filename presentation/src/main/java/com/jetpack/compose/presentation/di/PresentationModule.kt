package com.jetpack.compose.presentation.di

import com.jetpack.compose.domain.repository.Repository
import com.jetpack.compose.domain.usecase.GetCatUseCase
import com.jetpack.compose.domain.usecase.GetDogUseCase
import com.jetpack.compose.domain.usecase.GetRabbitUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    fun provideGetDogUseCase(repository: Repository): GetDogUseCase {
        return GetDogUseCase(repository)
    }

    @Provides
    fun provideGetCatUseCase(repository: Repository): GetCatUseCase {
        return GetCatUseCase(repository)
    }

    @Provides
    fun provideGetRabbitUseCase(repository: Repository): GetRabbitUseCase {
        return GetRabbitUseCase(repository)
    }
}