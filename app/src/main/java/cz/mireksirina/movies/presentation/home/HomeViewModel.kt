package cz.mireksirina.movies.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import cz.mireksirina.movies.domain.usecases.movies.MoviesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviesUseCases: MoviesUseCases
): ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    val movies = moviesUseCases.getPopularMovies(
    ).cachedIn(viewModelScope)
}