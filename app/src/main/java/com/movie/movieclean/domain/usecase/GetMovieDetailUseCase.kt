package com.movie.movieclean.domain.usecase

import com.movie.movieclean.data.remote.dto.detail.test.toDetail
import com.movie.movieclean.data.remote.dto.detail.toDetail
import com.movie.movieclean.domain.model.DetailTest
import com.movie.movieclean.domain.model.MovieDetail
import com.movie.movieclean.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int): DetailTest = repository.getMovieById(id).toDetail()
}
