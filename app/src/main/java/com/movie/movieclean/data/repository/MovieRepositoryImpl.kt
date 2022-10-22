package com.movie.movieclean.data.repository

import android.util.Log
import com.movie.movieclean.data.remote.dto.detail.DetailMovieDto
import com.movie.movieclean.data.remote.dto.detail.test.DetailDto
import com.movie.movieclean.data.remote.dto.popular.PopularMovieDto
import com.movie.movieclean.data.remote.dto.top_rated.TopRatedMovieDto
import com.movie.movieclean.data.remote.dto.up_coming.MovieUpComingModel
import com.movie.movieclean.data.remote.retrofit.ApiService
import com.movie.movieclean.domain.model.MovieDetail
import com.movie.movieclean.domain.repository.MovieRepository
import retrofit2.Call
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: ApiService
): MovieRepository {

    override suspend fun getMovies(): PopularMovieDto {
        return api.getListMovie()
    }

    override suspend fun getTopRatedList(): TopRatedMovieDto {
        return api.getListTopRated()
    }

    override suspend fun getUpComingList(): MovieUpComingModel {
        return api.getUpComingList()
    }

    override suspend fun getMovieById(id: Int): DetailDto {
        return api.getMovieById(id)
    }
}