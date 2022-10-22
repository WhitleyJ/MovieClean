package com.movie.movieclean.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.domain.usecase.GetListMovieUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel @Inject constructor(
    private val getListMovieUseCase: GetListMovieUseCase,
) : ViewModel() {

    val popularMovie: MutableLiveData<List<Movie>?> = MutableLiveData()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            popularMovie.value = getListMovieUseCase()
        }
    }
}