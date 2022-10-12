package com.example.moviesapplication.common.presentation.navigation.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.moviesapplication.movie_details.presentation.screen.MovieDetailsScreen
import com.example.moviesapplication.movie_details.presentation.viewmodel.MovieDetailsViewModel
import com.example.moviesapplication.movies_list.presentation.screen.MoviesListScreen
import com.example.moviesapplication.movies_list.presentation.viewmodel.MoviesListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController
) {
    val moviesListViewModel = getViewModel<MoviesListViewModel>()
    val movieDetailsViewModel = getViewModel<MovieDetailsViewModel>()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.MovieList.route
    ) {
        composable(
            route = AppRoutes.MovieList.route
        ) {
            MoviesListScreen(moviesListViewModel, navController)
        }
        composable(
            route = "${AppRoutes.MovieDetails.route}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val data = it.arguments?.getInt("id")
            MovieDetailsScreen(movieDetailsViewModel, data, navController)
        }
    }
}