package com.exercise.compose.di

import com.exercise.compose.data.remote.Service
import com.exercise.compose.data.repository.ProductRepositoryImpl
import com.exercise.compose.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUsersRepository(service: Service) : ProductRepository = ProductRepositoryImpl(service)
}