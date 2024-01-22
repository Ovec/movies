package cz.mireksirina.movies.data.remote

import cz.mireksirina.movies.data.remote.dto.MovieDetailResponse
import cz.mireksirina.movies.data.remote.dto.MovieListResponse
import cz.mireksirina.movies.util.Constants.API_KEY
import cz.mireksirina.movies.util.Constants.LANGUAGE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {


    // https://api.themoviedb.org/3/movie/popular?api_key=x&language=en-US&page=2
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
        @Query("page") page: Int
    ): MovieListResponse


    // https://api.themoviedb.org/3/movie/609681?api_key=x
    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Long,
        @Query("api_key") apiKey: String = API_KEY,
    ): MovieDetailResponse


    // https://api.themoviedb.org/3/search/movie?api_key=x&language=en-US&query=foo
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
        @Query("query") query: String,
        @Query("page") page: Int
    ): MovieListResponse
}