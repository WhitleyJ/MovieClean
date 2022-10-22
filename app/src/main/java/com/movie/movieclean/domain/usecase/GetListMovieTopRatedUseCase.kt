package com.movie.movieclean.domain.usecase

import com.movie.movieclean.data.remote.dto.top_rated.toMovie
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.domain.repository.MovieRepository
import javax.inject.Inject

class GetListMovieTopRatedUseCase @Inject constructor(private val repository: MovieRepository) {
    //маппер
    suspend operator fun invoke(): List<Movie> =
        repository.getTopRatedList().topRatedMovieDtoItems.map { it.toMovie() }
}