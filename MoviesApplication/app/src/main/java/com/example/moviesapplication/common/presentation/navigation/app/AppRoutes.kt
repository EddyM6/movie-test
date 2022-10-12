package com.example.moviesapplication.common.presentation.navigation.app

sealed class AppRoutes(val route: String) {
    object MovieList : AppRoutes(route = "movie_list")
    object MovieDetails : AppRoutes(route = "movie_details")
}