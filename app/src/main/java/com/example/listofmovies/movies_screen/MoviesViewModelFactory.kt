package com.example.listofmovies.movies_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listofmovies.movies_screen.pagination.MoviesPagingSource
import javax.inject.Inject

class MoviesViewModelFactory @Inject constructor(
    val pagingSource: MoviesPagingSource
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesViewModel(pagingSource) as T
    }
}