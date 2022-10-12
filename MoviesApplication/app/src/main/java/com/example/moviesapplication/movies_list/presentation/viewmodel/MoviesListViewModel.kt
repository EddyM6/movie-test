package com.example.moviesapplication.movies_list.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.moviesapplication.core.model.Result
import com.example.moviesapplication.core.mvi.UiStatus
import com.example.moviesapplication.core.viewmodel.BaseViewModel
import com.example.moviesapplication.movies_list.domain.usecase.GetMoviesListUseCase
import com.example.moviesapplication.movies_list.presentation.mapper.MoviesListDomainToUiMapper
import com.example.moviesapplication.movies_list.presentation.model.MoviesListSideEffect
import com.example.moviesapplication.movies_list.presentation.model.MoviesListViewState
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class MoviesListViewModel(
    private val moviesListDomainToUiMapper: MoviesListDomainToUiMapper,
    private val getMoviesListUseCase: GetMoviesListUseCase
) : BaseViewModel(), ContainerHost<MoviesListViewState, MoviesListSideEffect> {

    override val container =
        container<MoviesListViewState, MoviesListSideEffect>(MoviesListViewState.initial())

    init {
        getMoviesList()
    }

    private fun getMoviesList() {
        viewModelScope.launch {
            intent {
                reduce {
                    state.copy(
                        status = UiStatus.Loading
                    )
                }
                when (val result = getMoviesListUseCase.invoke(Unit)) {
                    is Result.Success -> {
                        reduce {
                            state.copy(
                                status = UiStatus.Success,
                                moviesList = moviesListDomainToUiMapper.map(result.data).results
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

    fun navigateToMovieDetailsScreen() = intent {
        postSideEffect(MoviesListSideEffect.NavigateToMovieDetailsScreen)
    }
}