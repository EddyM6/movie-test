package com.example.moviesapplication.movies_list.presentation.setup.di

import com.example.moviesapplication.movies_list.presentation.mapper.MoviesListDomainToUiMapper
import com.example.moviesapplication.movies_list.presentation.viewmodel.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moviesListPresentationModule = module {

    viewModel {
        MoviesListViewModel(
            moviesListDomainToUiMapper = get(),
            getMoviesListUseCase = get()
        )
    }
    factory { MoviesListDomainToUiMapper() }
}