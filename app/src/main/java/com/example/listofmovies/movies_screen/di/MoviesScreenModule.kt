package com.example.listofmovies.movies_screen.di

import com.example.listofmovies.APIService
import com.example.listofmovies.movies_screen.movies.ListMoviesDtoToModelMapper
import com.example.listofmovies.movies_screen.pagination.MoviesPagingSource
import com.example.listofmovies.movies_screen.ui.MoviesInteractor
import com.example.listofmovies.movies_screen.ui.MoviesInteractorImpl
import com.example.listofmovies.network.MoviesRepository
import com.example.listofmovies.network.MoviesRepositoryImpl
import com.example.listofmovies.network.ResponseMapper
import com.example.listofmovies.network.ResponseMapperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesScreenModule {

    @Provides
    @Singleton
    fun provideMoviesInteractor(
        repository: MoviesRepositoryImpl,
        mapper: ListMoviesDtoToModelMapper
    ): MoviesInteractor {
        return MoviesInteractorImpl(repository, mapper)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(
        responseMapper: ResponseMapper,
        service: APIService
    ): MoviesRepository {
        return MoviesRepositoryImpl(responseMapper, service)
    }

    @Provides
    @Singleton
    fun provideListMoviesDtoToModelMapper(): ListMoviesDtoToModelMapper {
        return ListMoviesDtoToModelMapper()
    }

    @Provides
    @Singleton
    fun provideResponseMapper(): ResponseMapper {
        return ResponseMapperImpl()
    }

    @Provides
    @Singleton
    fun provideMoviesPagingSource(
        service: APIService,
        mapper: ListMoviesDtoToModelMapper
    ): MoviesPagingSource {
        return MoviesPagingSource(service, mapper)
    }
}