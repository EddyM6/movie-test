package com.example.moviesapplication.movie_details.domain.di

import com.example.moviesapplication.core.di.DispatchersName
import com.example.moviesapplication.movie_details.domain.mapper.MovieDetailsDataToDomainMapper
import com.example.moviesapplication.movie_details.domain.usecase.GetMovieDetailsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val movieDetailsDomainModule = module {

    factory {
        GetMovieDetailsUseCase(
            coroutineDispatcher = get(qualifier = named(DispatchersName.IO)),
            movieDetailsDataToDomainMapper = get(),
            movieDetailsRepository = get()
        )
    }
    factory { MovieDetailsDataToDomainMapper() }
}