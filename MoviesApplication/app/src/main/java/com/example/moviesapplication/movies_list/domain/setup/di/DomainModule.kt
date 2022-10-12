package com.example.moviesapplication.movies_list.domain.setup.di

import com.example.moviesapplication.core.di.DispatchersName
import com.example.moviesapplication.movies_list.domain.mapper.MoviesListDataToDomainMapper
import com.example.moviesapplication.movies_list.domain.usecase.GetMoviesListUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val moviesListDomainModule = module {

    factory {
        GetMoviesListUseCase(
            coroutineDispatcher = get(qualifier = named(DispatchersName.IO)),
            moviesListDataToDomainMapper = get(),
            moviesListRepository = get()
        )
    }
    factory { MoviesListDataToDomainMapper() }
}