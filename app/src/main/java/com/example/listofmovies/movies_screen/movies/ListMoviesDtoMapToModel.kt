package com.example.listofmovies.movies_screen.movies

import com.example.listofmovies.movies_screen.MovieDto
import com.example.listofmovies.movies_screen.MovieModel
import com.example.listofmovies.movies_screen.MultimediaModel
import com.example.listofmovies.movies_screen.ResultsModel
import com.example.listofmovies.settings.Mapper
import javax.inject.Inject

class ListMoviesDtoToModelMapper @Inject constructor() : Mapper<ResultsResponse, ResultsModel> {
    override fun map(from: ResultsResponse): ResultsModel = ResultsModel(
        listOfMovies = from.listOfMovies?.map {
            MovieModel(
                title = it.title,
                description = it.description,
                multimedia = MultimediaModel(
                    image = it.multimedia?.image
                )
            )
        } ?: emptyList()
    )

    fun toModel(from: MovieDto): MovieModel = MovieModel(
        title = from.title,
        description = from.description,
        multimedia = MultimediaModel(
            image = from.multimedia?.image
        )
    )
}