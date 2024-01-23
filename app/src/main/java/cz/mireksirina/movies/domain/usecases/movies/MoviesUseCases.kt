package cz.mireksirina.movies.domain.usecases.movies

data class MoviesUseCases(
    val getPopularMovies: GetPopularMovies,
    val searchMovies: SearchMovies
)

// cz.mireksirina.movies