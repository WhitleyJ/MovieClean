package com.movie.movieclean.data.remote.dto.up_coming

import com.movie.movieclean.data.remote.dto.top_rated.TopRatedMovieDtoItem
import com.movie.movieclean.domain.model.Movie

data class MovieUpComingModelItem(
    val adult: Boolean,
    val backdrop_path: String,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean
)
fun MovieUpComingModelItem.toMovie(): Movie {
    return Movie(
        adult = adult,
        backdrop_path = backdrop_path,
        id = id,
        original_language = original_language,
        original_title = original_title,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        video = video
    )
}