package com.movie.movieclean.data.repository

import com.movie.movieclean.data.remote.retrofit.ApiService
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: ApiService
): MovieRepository {
    //change too
    override suspend fun getListMovie(): List<Movie> {
        return api.getListMovie()
    }
    //change on detail movie dto
    override suspend fun getMovieById(id: String): Movie {
        return api.getMovieById(id)
    }
}