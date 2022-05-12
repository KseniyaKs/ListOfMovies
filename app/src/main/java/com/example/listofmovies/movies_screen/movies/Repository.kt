package com.example.listofmovies.network

import com.example.listofmovies.APIService
import com.example.listofmovies.movies_screen.movies.ResultsResponse
import javax.inject.Inject

interface MoviesRepository {
    suspend fun getMovies(): ResultsResponse?
}

class MoviesRepositoryImpl @Inject constructor(
    private val responseMapper: ResponseMapper,
    private val service: APIService
) : MoviesRepository {

    override suspend fun getMovies(): ResultsResponse? =
        responseMapper.map(
            service.getMovies(offset = 0)
        )
}