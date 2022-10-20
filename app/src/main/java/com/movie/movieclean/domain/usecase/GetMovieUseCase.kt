package com.movie.movieclean.domain.usecase

import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {

    operator fun invoke(): Movie = repository.getMovieById()
}