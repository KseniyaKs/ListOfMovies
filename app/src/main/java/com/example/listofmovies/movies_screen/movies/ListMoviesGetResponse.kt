package com.example.listofmovies.movies_screen.movies

import com.example.listofmovies.movies_screen.MovieDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ResultsResponse(
    @field:Json(name = "results") val listOfMovies: List<MovieDto>?
)
