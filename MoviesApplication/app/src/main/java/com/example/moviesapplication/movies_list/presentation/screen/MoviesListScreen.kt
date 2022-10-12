package com.example.moviesapplication.movies_list.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moviesapplication.R
import com.example.moviesapplication.common.presentation.navigation.app.AppRoutes
import com.example.moviesapplication.common.presentation.util.ProgressBar
import com.example.moviesapplication.core.mvi.UiStatus
import com.example.moviesapplication.movies_list.presentation.model.MoviesListSideEffect
import com.example.moviesapplication.movies_list.presentation.screen.component.MovieCard
import com.example.moviesapplication.movies_list.presentation.viewmodel.MoviesListViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MoviesListScreen(
    moviesListViewModel: MoviesListViewModel,
    navController: NavController
) {
    val state by moviesListViewModel.collectAsState()
    var selectedMovieId by remember { mutableStateOf(0) }

    moviesListViewModel.collectSideEffect { sideEffects ->
        when (sideEffects) {
            is MoviesListSideEffect.NavigateToMovieDetailsScreen -> {
                navController.navigate("${AppRoutes.MovieDetails.route}/$selectedMovieId")
            }
        }
    }

    when (state.status) {

        is UiStatus.Loading -> {
            ProgressBar()
        }
        is UiStatus.Success -> {
            state.moviesList?.let {
                if (it.isEmpty())
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = stringResource(id = R.string.no_results_found))
                    }
                else
                    LazyColumn(
                        contentPadding = PaddingValues(vertical = 12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(it) { item ->
                            MovieCard(
                                title = item?.title ?: "",
                                releaseDate = item?.release_date ?: "",
                                imageUrl = item?.poster_path ?: "",
                                modifier = Modifier.clickable {
                                    selectedMovieId = item?.id ?: 0
                                    if (item?.id != null) {
                                        moviesListViewModel.navigateToMovieDetailsScreen()
                                    }
                                }
                            )
                        }
                    }
            }
        }
        is UiStatus.Failed -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = (state.status as UiStatus.Failed).message)
            }
        }
    }

}