package com.movie.movieclean.data.remote.dto.detail

import com.movie.movieclean.domain.model.MovieDetail

data class DetailMovieDto(
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

fun DetailMovieDto.toDetail(): MovieDetail{
    return MovieDetail(
        backdrop_path = backdrop_path,
        budget = budget,
        genres = genres,
        homepage = homepage,
        id = id,
        imdb_id = imdb_id,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        production_countries = production_countries,
        release_date = release_date,
        revenue = revenue,
        status = status,
        title = title,
        video = video,
        vote_average = vote_average,
        vote_count = vote_count
    )
}