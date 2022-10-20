package com.movie.movieclean.data.remote.retrofit

import com.movie.movieclean.domain.model.Movie
import retrofit2.http.GET

interface ApiService {
    //change this on dto
    @GET("")
    suspend fun getListMovie(): List<Movie>

    //detail film
    @GET("")
    suspend fun getMovieById(id: String): Movie
}