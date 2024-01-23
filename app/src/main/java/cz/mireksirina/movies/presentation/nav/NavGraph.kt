package cz.mireksirina.movies.presentation.nav

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import cz.mireksirina.movies.domain.model.Result
import cz.mireksirina.movies.presentation.home.HomeScreen
import cz.mireksirina.movies.presentation.home.HomeViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.MoviesNavigation.route,
            startDestination = Route.PopularScreen.route
        ) {
            composable(route = Route.PopularScreen.route) {
                val viewModel: HomeViewModel = hiltViewModel()
                val movies = viewModel.movies.collectAsLazyPagingItems()

                val mockResult = Result(
                    adult = false,
                    backdrop_path = "/example_backdrop_path.jpg",
                    genre_ids = listOf(28, 12, 16),
                    id = 12345,
                    original_language = "en",
                    original_title = "Mock Movie Title",
                    overview = "This is a mock overview of the movie.",
                    popularity = 87.5,
                    poster_path = "/example_poster_path.jpg",
                    release_date = "2024-01-23",
                    title = "Mock Movie Title",
                    video = true,
                    vote_average = 8.9,
                    vote_count = 1000
                )

                fun mockResultHandler(result: Result) {
                    println("Processing movie result:")
                    println("Title: ${result.title}")
                    println("Overview: ${result.overview}")
                    println("Release Date: ${result.release_date}")
                    println("Popularity: ${result.popularity}")
                    println("Vote Average: ${result.vote_average}")

                    // Add any other processing or actions you want to perform with the result
                }

                val navigateToDetails = { mockResult: Result -> mockResultHandler(mockResult) }

                HomeScreen(movies = movies, navigateToSearch = { /*TODO*/ }, navigateToDetails = navigateToDetails)
                Text(text= "Popular screen")

            }
            composable(route = Route.SearchScreen.route) {
                Text(text= "SearchScreen")
            }
            composable(route = Route.BookmarkScreen.route) {
                Text(text= "BookmarkScreen")

            }
            composable(route = Route.DetailsScreen.route) {
                Text(text= "DetailsScreen")

            }
        }
    }
}
