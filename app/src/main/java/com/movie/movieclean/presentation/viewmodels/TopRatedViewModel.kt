package com.movie.movieclean.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.domain.usecase.GetListMovieTopRatedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopRatedViewModel @Inject constructor(
    private val getListMovieTopRatedUseCase: GetListMovieTopRatedUseCase,
) :
    ViewModel() {

    val listMovieRated: MutableLiveData<List<Movie>?> = MutableLiveData()

    init {
        getMoviesRated()
    }

    private fun getMoviesRated() {
        viewModelScope.launch(Dispatchers.Main) {
            listMovieRated.value = getListMovieTopRatedUseCase()
        }
    }

}