//package cz.mireksirina.movies.data.remote
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import cz.mireksirina.movies.data.remote.dto.MovieDetailResponse
//import cz.mireksirina.movies.domain.model.Result
//
//
//class MovieDetailSource(
//    private val moviesApi: MoviesApi,
//    private val movieId: Long,
//) {
//    suspend fun getMovieDetail(): Flow<MovieDetailResponse> = flow {
//        try {
//            val movieDetailResponse = moviesApi.getMovieDetails(movieId = movieId)
//            emit(movieDetailResponse)
//        } catch (e: Exception) {
//            // Handle the exception, for example, you can emit an error state
//            e.printStackTrace()
//            // You might want to emit an error state or rethrow the exception
//        }
//    }
//}