package cz.mireksirina.movies.presentation.nav


sealed class Route(
    val route: String
) {
    object PopularScreen : Route(route = "popularScreen")

    object SearchScreen : Route(route = "searchScreen")

    object BookmarkScreen : Route(route = "bookMarkScreen")

    object DetailsScreen : Route(route = "detailsScreen")

    // object AppStartNavigation : Route(route = "popularScreen")

    object MoviesNavigation : Route(route = "moviesNavigation")
}
