package com.jetpack.compose.data.di

import com.jetpack.compose.data.remote.RemoteSource
import com.jetpack.compose.data.remote.RemoteSourceImpl
import com.jetpack.compose.data.repository.RepositoryImpl
import com.jetpack.compose.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractModule {

    @Binds
    abstract fun bindRemoteSource(remoteSourceImpl: RemoteSourceImpl): RemoteSource

    @Binds
    abstract fun bindRepository(repositoryImpl: RepositoryImpl): Repository
}