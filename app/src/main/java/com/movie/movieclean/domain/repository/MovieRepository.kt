package com.movie.movieclean.domain.repository

import com.movie.movieclean.data.remote.dto.detail.DetailMovieDto
import com.movie.movieclean.data.remote.dto.detail.test.DetailDto
import com.movie.movieclean.data.remote.dto.popular.PopularMovieDto
import com.movie.movieclean.data.remote.dto.top_rated.TopRatedMovieDto
import com.movie.movieclean.data.remote.dto.up_coming.MovieUpComingModel
import com.movie.movieclean.domain.model.MovieDetail
import retrofit2.Call

interface MovieRepository {

    suspend fun getMovies(): PopularMovieDto

    suspend fun getTopRatedList(): TopRatedMovieDto

    suspend fun getUpComingList(): MovieUpComingModel

    suspend fun getMovieById(id: Int): DetailDto

}