package com.example.moviesapplication.movie_details.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.core.model.Result
import com.example.moviesapplication.core.mvi.UiStatus
import com.example.moviesapplication.core.viewmodel.BaseViewModel
import com.example.moviesapplication.movie_details.domain.usecase.GetMovieDetailsUseCase
import com.example.moviesapplication.movie_details.presentation.mapper.MovieDetailsDomainToUiMapper
import com.example.moviesapplication.movie_details.presentation.model.MovieDetailsSideEffect
import com.example.moviesapplication.movie_details.presentation.model.MovieDetailsViewState
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MovieDetailsViewModel(
    private val movieDetailsDomainToUiMapper: MovieDetailsDomainToUiMapper,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase
) : BaseViewModel(), ContainerHost<MovieDetailsViewState, MovieDetailsSideEffect> {

    override val container =
        container<MovieDetailsViewState, MovieDetailsSideEffect>(MovieDetailsViewState.initial())

    fun getCurrentMovieDetails(id: Int) {
        viewModelScope.launch {
            intent {
                reduce {
                    state.copy(
                        status = UiStatus.Loading
                    )
                }
                when (val result = getMovieDetailsUseCase.invoke(id)) {
                    is Result.Success -> {
                        reduce {
                            state.copy(
                                status = UiStatus.Success,
                                movieDetails = movieDetailsDomainToUiMapper.map(result.data)
                            )
                        }
                    }
                    is Result.Error -> {
                        reduce {
                            state.copy(
                                status = UiStatus.Failed(
                                    result.error.message ?: ""
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    fun navigateToBack() = intent {
        postSideEffect(MovieDetailsSideEffect.NavigateToBack)
    }
}