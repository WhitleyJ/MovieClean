package com.movie.movieclean.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.movieclean.domain.model.DetailTest
import com.movie.movieclean.domain.model.MovieDetail
import com.movie.movieclean.domain.usecase.GetMovieDetailUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
) : ViewModel() {
    val detailList: MutableLiveData<DetailTest?> = MutableLiveData()

    fun getDetailById(id: Int) {
        viewModelScope.launch {
            try {
                detailList.value = getMovieDetailUseCase(id)
            }catch (e:Exception){
                throw RuntimeException("not found")
            }

            Log.d("detailList", id.toString())
        }
    }

}

