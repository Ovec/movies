package cz.mireksirina.movies.presentation.home

data class HomeState(
    val movieId: Long = 0,
    val isLoading: Boolean = false,
)