package com.movie.movieclean.domain.usecase

import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.domain.repository.MovieRepository
import javax.inject.Inject

class GetListMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    operator fun invoke(): List<Movie> = repository.getListMovie()
}