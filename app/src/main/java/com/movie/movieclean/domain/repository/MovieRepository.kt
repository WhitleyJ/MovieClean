package com.movie.movieclean.domain.repository

import com.movie.movieclean.domain.model.Movie

interface MovieRepository {
    // in module add this interface

    // change on dto item
    suspend fun getListMovie(): List<Movie>

    //too
    suspend fun getMovieById(id: String): Movie

}