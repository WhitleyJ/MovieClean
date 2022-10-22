package com.movie.movieclean.data.remote.retrofit

import com.movie.movieclean.data.remote.dto.detail.DetailMovieDto
import com.movie.movieclean.data.remote.dto.detail.test.DetailDto
import com.movie.movieclean.data.remote.dto.top_rated.TopRatedMovieDto
import com.movie.movieclean.data.remote.dto.popular.PopularMovieDto
import com.movie.movieclean.data.remote.dto.up_coming.MovieUpComingModel
import com.movie.movieclean.domain.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("3/movie/popular?api_key=b1fe138d46728cd570cf0ec8cb2b0097&language=en-US&page=1")
    suspend fun getListMovie(): PopularMovieDto

    @GET("3/movie/top_rated?api_key=b1fe138d46728cd570cf0ec8cb2b0097&language=en-US&page=1")
    suspend fun getListTopRated(): TopRatedMovieDto

    @GET("3/movie/upcoming?api_key=b1fe138d46728cd570cf0ec8cb2b0097&language=en-US&page=1")
    suspend fun getUpComingList(): MovieUpComingModel

    @GET("3/movie/{movie_id}")
    suspend fun getMovieById(@Path("movie_id")id:Int): DetailDto
}