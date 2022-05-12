package com.example.listofmovies.movies_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.listofmovies.movies_screen.pagination.MoviesPagingSource
import com.example.listofmovies.movies_screen.ui.MoviesInteractorImpl
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


class MoviesViewModel @Inject constructor(
    private val pagingSource: MoviesPagingSource
) : ViewModel() {

    val movies: StateFlow<PagingData<MovieModel>> = Pager(PagingConfig(pageSize = 20)) {
        pagingSource
    }.flow
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

}
