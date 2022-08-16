package com.jetpack.compose.data.di

import com.jetpack.compose.data.api.ApiService
import com.jetpack.compose.data.api.RetrofitBuilder
import com.jetpack.compose.data.remote.RemoteSource
import com.jetpack.compose.data.remote.RemoteSourceImpl
import com.jetpack.compose.data.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideApiService(): ApiService =
        RetrofitBuilder.getRetrofit().create(ApiService::class.java)

    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @Provides
    fun provideRemoteSource(apiService: ApiService): RemoteSourceImpl {
        return RemoteSourceImpl(apiService)
    }

    @Provides
    fun provideRepository(
        ioDispatcher: CoroutineDispatcher,
        remoteSource: RemoteSource
    ): RepositoryImpl {
        return RepositoryImpl(ioDispatcher, remoteSource)
    }
}