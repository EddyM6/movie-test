package com.example.moviesapplication.movies_list.presentation.model

import androidx.compose.runtime.Immutable

@Immutable
sealed class MoviesListSideEffect {

    object NavigateToMovieDetailsScreen : MoviesListSideEffect()
}