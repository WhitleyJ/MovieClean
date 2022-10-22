package com.movie.movieclean.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.domain.usecase.GetUpComingMovieUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ViewModelUp @Inject constructor(private val getUpComingMovieUseCase: GetUpComingMovieUseCase) :
    ViewModel() {

    var listUpComing: MutableLiveData<List<Movie>?> = MutableLiveData()

    init {
        getUpComingMovie()
    }

    private fun getUpComingMovie() {
        viewModelScope.launch {
            listUpComing.value = getUpComingMovieUseCase()
        }
    }
}