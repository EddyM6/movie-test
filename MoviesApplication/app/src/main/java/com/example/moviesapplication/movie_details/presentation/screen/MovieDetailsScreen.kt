package com.example.moviesapplication.movie_details.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moviesapplication.BuildConfig
import com.example.moviesapplication.common.presentation.navigation.BackPressHandler
import com.example.moviesapplication.common.presentation.util.ProgressBar
import com.example.moviesapplication.core.mvi.UiStatus
import com.example.moviesapplication.movie_details.presentation.model.MovieDetailsSideEffect
import com.example.moviesapplication.movie_details.presentation.viewmodel.MovieDetailsViewModel
import com.skydoves.landscapist.glide.GlideImage
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MovieDetailsScreen(
    movieDetailsViewModel: MovieDetailsViewModel,
    movieId: Int?,
    navController: NavController
) {
    val state by movieDetailsViewModel.collectAsState()

    LaunchedEffect(
        key1 = movieDetailsViewModel,
        block = { movieDetailsViewModel.getCurrentMovieDetails(id = movieId ?: 0) }
    )
    BackPressHandler {
        movieDetailsViewModel.navigateToBack()
    }

    movieDetailsViewModel.collectSideEffect { sideEffects ->
        when (sideEffects) {
            is MovieDetailsSideEffect.NavigateToBack -> {
                navController.popBackStack()
            }
        }
    }

    when (state.status) {

        is UiStatus.Loading -> {
            ProgressBar()
        }
        is UiStatus.Success -> {
            state.movieDetails?.let {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    GlideImage(
                        modifier = Modifier.fillMaxWidth(),
                        imageModel = BuildConfig.IMAGES_BASE_URL + it.poster_path,
                        contentScale = ContentScale.FillWidth
                    )
                    Text(
                        text = it.title ?: "",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = it.release_date?.substringBefore('-') ?: "",
                        fontSize = 16.sp
                    )
                    Text(
                        text = it.overview ?: "",
                        fontSize = 20.sp
                    )
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