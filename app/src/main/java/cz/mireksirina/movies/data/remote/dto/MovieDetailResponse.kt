package cz.mireksirina.movies.data.remote.dto

import cz.mireksirina.movies.domain.model.BelongsToCollection
import cz.mireksirina.movies.domain.model.Genre
import cz.mireksirina.movies.domain.model.ProductionCompany
import cz.mireksirina.movies.domain.model.ProductionCountry
import cz.mireksirina.movies.domain.model.SpokenLanguage

data class MovieDetailResponse(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongsToCollection,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)