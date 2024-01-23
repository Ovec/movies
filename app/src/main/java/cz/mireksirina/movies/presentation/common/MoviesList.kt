package cz.mireksirina.movies.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import cz.mireksirina.movies.domain.model.Result
import cz.mireksirina.movies.presentation.home.components.MovieCard
import cz.mireksirina.movies.util.Constants.ExtraSmallPadding2
import cz.mireksirina.movies.util.Constants.MediumPadding1


@Composable
fun MoviesList(
    modifier: Modifier = Modifier,
    movies: LazyPagingItems<Result>,
    onClick:(Result) -> Unit
) {

    val handlePagingResult = handlePagingResult(movies)


    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {
            items(
                count = movies.itemCount,
            ) {
                movies[it]?.let { movie ->
                    MovieCard(movie = movie, onClick = {onClick(movie)})
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(articles: LazyPagingItems<Result>): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error = error)
            false
        }

        else -> {
            true
        }
    }
}

@Composable
fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)){
        repeat(10){
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}