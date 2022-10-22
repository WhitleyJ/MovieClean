package com.movie.movieclean.di

import com.movie.movieclean.Constance.BASE_URL
import com.movie.movieclean.data.remote.retrofit.ApiService
import com.movie.movieclean.data.repository.MovieRepositoryImpl
import com.movie.movieclean.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface DataModule {


    companion object {


        @Provides
        @AppScope
        fun provideApiService(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

        @Provides
        @AppScope
        fun provideApi(api: ApiService): MovieRepository {
            return MovieRepositoryImpl(api)
        }
    }
}