package cz.mireksirina.movies.data.remote.dto

import cz.mireksirina.movies.domain.model.Result

data class MovieListResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)