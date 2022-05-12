package com.example.listofmovies.movies_screen

import android.media.Image
import com.squareup.moshi.Json

data class ResultsModel(
    val listOfMovies: List<MovieModel>?
)

data class MovieModel(
    val title: String,
    val description: String?,
    val multimedia: MultimediaModel?
)

data class MultimediaModel(
    val image: String?
)
