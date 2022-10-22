package com.movie.movieclean.di

import androidx.lifecycle.ViewModel
import com.movie.movieclean.presentation.viewmodels.DetailViewModel
import com.movie.movieclean.presentation.viewmodels.ListViewModel
import com.movie.movieclean.presentation.viewmodels.TopRatedViewModel
import com.movie.movieclean.presentation.viewmodels.ViewModelUp
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    fun bindListViewModel(impl: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TopRatedViewModel::class)
    fun bindRatedViewModel(impl: TopRatedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelUp::class)
    fun bindViewModelUp(impl: ViewModelUp): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(impl: DetailViewModel): ViewModel


}