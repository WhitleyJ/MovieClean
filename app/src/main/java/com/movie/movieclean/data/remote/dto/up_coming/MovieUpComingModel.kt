package com.movie.movieclean.data.remote.dto.up_coming

import com.google.gson.annotations.SerializedName

data class MovieUpComingModel(
    val dates: Dates,
    val page: Int,
    @SerializedName("results") val movieUpComingModelItems: List<MovieUpComingModelItem>,
    val total_pages: Int,
    val total_results: Int
)