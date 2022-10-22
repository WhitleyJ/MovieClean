package com.movie.movieclean.data.remote.dto.popular

import com.google.gson.annotations.SerializedName

data class PopularMovieDto(
    @SerializedName ("results") val popularMovieDtoItems: List<PopularMovieDtoItem>,
    val page: Int,
    val total_pages: Int,
    val total_results: Int
)