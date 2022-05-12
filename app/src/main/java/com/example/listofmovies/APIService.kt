package com.example.listofmovies

import com.example.listofmovies.movies_screen.movies.ResultsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("/svc/movies/v2/reviews/all.json")
    suspend fun getMovies(
        @Query("api-key") api_key: String = BuildConfig.API_KEY,
        @Query("offset") offset: Int
    ): Response<ResultsResponse>
}