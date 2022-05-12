package com.example.listofmovies.movies_screen.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.listofmovies.APIService
import com.example.listofmovies.movies_screen.MovieModel
import com.example.listofmovies.movies_screen.movies.ListMoviesDtoToModelMapper
import retrofit2.HttpException
import javax.inject.Inject

private const val OFFSET_CONST = 20

class MoviesPagingSource @Inject constructor(
    private val service: APIService,
    private val mapper: ListMoviesDtoToModelMapper
) : PagingSource<Int, MovieModel>() {

    override fun getRefreshKey(state: PagingState<Int, MovieModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieModel> {
        val offset: Int = params.key ?: 0
        val response = service.getMovies(offset = offset)
        return if (response.isSuccessful) {
            val movies = checkNotNull(response.body()).listOfMovies?.map { mapper.toModel(it) }
            val nextKey = if (movies?.isNullOrEmpty() == true) null else offset + OFFSET_CONST
            val prevKey = null
            LoadResult.Page(movies, prevKey, nextKey)
        } else {
            LoadResult.Error(HttpException(response))
        }
    }
}