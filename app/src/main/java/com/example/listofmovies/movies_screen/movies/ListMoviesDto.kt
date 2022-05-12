package com.example.listofmovies.movies_screen

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class MovieDto(
    @field:Json(name = "display_title") val title: String,
    @field:Json(name = "summary_short") val description: String?,
    @field:Json(name = "multimedia") val multimedia: MultimediaDto?
)

@JsonClass(generateAdapter = true)
data class MultimediaDto(
    @field:Json(name = "src") val image: String?
)