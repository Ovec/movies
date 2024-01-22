package cz.mireksirina.movies.domain.repository

import androidx.paging.PagingData
import cz.mireksirina.movies.data.remote.dto.MovieDetailResponse
import kotlinx.coroutines.flow.Flow
import cz.mireksirina.movies.domain.model.Result

interface MoviesRepository {
    fun popularMovies(): Flow<PagingData<Result>>

    fun searchMovies(query: String): Flow<PagingData<Result>>

    // fun movieDetail(movieId: Long): Flow<MovieDetailResponse>

}
