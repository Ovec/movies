package cz.mireksirina.movies.domain.usecases.movies

import androidx.paging.PagingData
import cz.mireksirina.movies.domain.model.Result
import cz.mireksirina.movies.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow

class SearchMovies(
    private val moviesRepository: MoviesRepository,
) {
    operator fun invoke(query: String): Flow<PagingData<Result>> {
        return moviesRepository.searchMovies(query)
    }
}