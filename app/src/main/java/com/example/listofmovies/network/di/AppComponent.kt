package com.example.listofmovies.network.di

import com.example.listofmovies.movies_screen.di.MoviesScreenModule
import com.example.listofmovies.movies_screen.ui.MoviesFragment
import com.example.myapplicationone.di.AppModule
import com.example.myapplicationone.di.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RetrofitModule::class,
        MoviesScreenModule::class
    ]
)

interface AppComponent {
    fun injectMoviesFragment(moviesFragment: MoviesFragment)
}
