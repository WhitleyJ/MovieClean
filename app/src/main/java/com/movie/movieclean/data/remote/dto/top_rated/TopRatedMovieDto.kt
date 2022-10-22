package com.movie.movieclean.data.remote.dto.top_rated

import com.google.gson.annotations.SerializedName

data class TopRatedMovieDto(
    val page: Int,
    @SerializedName("results") val topRatedMovieDtoItems: List<TopRatedMovieDtoItem>,
    val total_pages: Int,
    val total_results: Int
)