package com.example.moviesapplication.movie_details.presentation.setup.di

import com.example.moviesapplication.movie_details.presentation.mapper.MovieDetailsDomainToUiMapper
import com.example.moviesapplication.movie_details.presentation.viewmodel.MovieDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieDetailsPresentationModule = module {

    viewModel {
        MovieDetailsViewModel(
            movieDetailsDomainToUiMapper = get(),
            getMovieDetailsUseCase = get()
        )
    }
    factory { MovieDetailsDomainToUiMapper() }
}