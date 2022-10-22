package com.movie.movieclean.domain.usecase

import com.movie.movieclean.data.remote.dto.popular.toMovie
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.domain.repository.MovieRepository
import javax.inject.Inject

class GetListMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(): List<Movie> =
        repository.getMovies().popularMovieDtoItems.map { it.toMovie() }
}