package com.example.listofmovies.movies_screen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.listofmovies.movies_screen.MovieModel
import com.example.listofmovies.movies_screen.ResultsModel
import com.example.listofmovies.movies_screen.movies.ListMoviesDtoToModelMapper
import com.example.listofmovies.network.MoviesRepositoryImpl
import java.time.LocalDate
import javax.inject.Inject

interface MoviesInteractor {

    val listOfMovies: LiveData<List<MovieModel>?>

    suspend fun getMovies(): List<MovieModel>?
}

class MoviesInteractorImpl @Inject constructor(
    private val repository: MoviesRepositoryImpl,
    private val mapper: ListMoviesDtoToModelMapper
) : MoviesInteractor {

    private val _listOfMovies = MutableLiveData<List<MovieModel>?>()
    override val listOfMovies: LiveData<List<MovieModel>?> = _listOfMovies

    override suspend fun getMovies(): List<MovieModel>? {
        val listOfMovies = repository.getMovies().let {
            mapper.map(it!!).listOfMovies
        }
        _listOfMovies.postValue(listOfMovies)
        return listOfMovies
    }
}
