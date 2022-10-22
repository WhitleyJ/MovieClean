package com.movie.movieclean.domain.model

import com.movie.movieclean.data.remote.dto.detail.Genre
import com.movie.movieclean.data.remote.dto.detail.ProductionCountry

data class MovieDetail(
    val backdrop_path: String,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val status: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)