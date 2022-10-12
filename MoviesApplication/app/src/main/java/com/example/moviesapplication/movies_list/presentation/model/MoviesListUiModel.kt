package com.example.moviesapplication.movies_list.presentation.model

data class MoviesListUiModel(
    val page: Int?,
    val results: List<Result?>?,
    val total_pages: Int?,
    val total_results: Int?
) {
    data class Result(
        val adult: Boolean?,
        val id: Int?,
        val poster_path: String?,
        val release_date: String?,
        val title: String?,
        val vote_average: Double?,
        val vote_count: Int?
    )
}