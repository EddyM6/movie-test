package com.example.moviesapplication.movie_details.presentation.model

import com.example.moviesapplication.core.mvi.UiStatus

data class MovieDetailsViewState(
    val status: UiStatus,
    val movieDetails: MovieDetailsUiModel?,
    val selectedMovieId: Int
) {
    companion object {
        fun initial() = MovieDetailsViewState(
            status = UiStatus.Loading,
            movieDetails = null,
            selectedMovieId = 0
        )
    }
}