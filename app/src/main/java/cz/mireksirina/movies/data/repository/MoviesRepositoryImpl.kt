package cz.mireksirina.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import cz.mireksirina.movies.data.remote.MoviesApi
import cz.mireksirina.movies.data.remote.MoviesPagingSource
import cz.mireksirina.movies.data.remote.SearchMoviesPagingSource
import cz.mireksirina.movies.data.remote.dto.MovieDetailResponse
import cz.mireksirina.movies.domain.model.Result
import cz.mireksirina.movies.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow


class MoviesRepositoryImpl constructor(
    private val moviesApi: MoviesApi
) : MoviesRepository {

    override fun popularMovies(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                MoviesPagingSource(moviesApi = moviesApi)
            }
        ).flow
    }

    override fun searchMovies(query: String): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchMoviesPagingSource(moviesApi = moviesApi, query = query)
            }
        ).flow
    }

//    override fun movieDetail(movieId: Long): Flow<MovieDetailResponse> {
//
//        return moviesApi.getMovieDetails(movieId = movieId).flow
//
//    }


}