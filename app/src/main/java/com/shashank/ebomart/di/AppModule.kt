package com.shashank.ebomart.di

import com.shashank.ebomart.remote.api.EboApi
import com.shashank.ebomart.repository.EdoMovieRepository
import com.shashank.ebomart.repository.EdoMovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Singleton
    @Provides
    fun provideRepositroy(api: EboApi): EdoMovieRepository {
        return EdoMovieRepositoryImpl(api)
    }
}