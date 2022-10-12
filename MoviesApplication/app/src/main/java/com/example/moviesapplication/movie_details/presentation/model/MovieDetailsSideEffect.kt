package com.example.moviesapplication.movie_details.presentation.model

import androidx.compose.runtime.Immutable

@Immutable
sealed class MovieDetailsSideEffect {

    object NavigateToBack : MovieDetailsSideEffect()
}