package com.example.moviesapplication.movies_list.presentation.model

import com.example.moviesapplication.core.mvi.UiStatus

data class MoviesListViewState(
    val status: UiStatus,
    val moviesList: List<MoviesListUiModel.Result?>?
) {
    companion object {
        fun initial() = MoviesListViewState(
            status = UiStatus.Loading,
            moviesList = emptyList()
        )
    }
}