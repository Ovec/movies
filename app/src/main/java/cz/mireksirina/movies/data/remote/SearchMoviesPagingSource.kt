package cz.mireksirina.movies.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import cz.mireksirina.movies.domain.model.Result

class SearchMoviesPagingSource(
    private val moviesApi: MoviesApi,
    private val query: String,
) : PagingSource<Int, Result>() {


    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val page = params.key ?: 1
        return try {
            val moviesResponse = moviesApi.searchMovies(page = page, query = query)
            val movies = moviesResponse.results

            LoadResult.Page(
                data = movies,
                nextKey = if (page == moviesResponse.total_pages) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}