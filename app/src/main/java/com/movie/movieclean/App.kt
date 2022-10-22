package com.movie.movieclean

import android.app.Application
import com.movie.movieclean.di.DaggerAppComponent

class App: Application() {
    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}