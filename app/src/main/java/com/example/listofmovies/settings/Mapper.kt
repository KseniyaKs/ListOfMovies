package com.example.listofmovies.settings


interface Mapper<T, R> {

    fun map(from: T): R
}

