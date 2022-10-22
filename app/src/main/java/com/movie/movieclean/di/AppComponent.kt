package com.movie.movieclean.di

import android.app.Application
import com.movie.movieclean.presentation.fragments.DetailFragment
import com.movie.movieclean.presentation.fragments.ListFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(fragment: ListFragment)

    fun inject(fragment: DetailFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
        ): AppComponent
    }
}