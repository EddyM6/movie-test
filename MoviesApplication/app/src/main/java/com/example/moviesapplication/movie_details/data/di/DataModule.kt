package com.example.moviesapplication.movie_details.data.di

import com.example.moviesapplication.movie_details.data.api.MovieDetailsApiService
import com.example.moviesapplication.movie_details.data.remote.MovieDetailsRemoteDataSource
import com.example.moviesapplication.movie_details.data.remote.impl.MovieDetailsRemoteDataSourceImpl
import com.example.moviesapplication.movie_details.data.repository.MovieDetailsRepository
import com.example.moviesapplication.movie_details.data.repository.impl.MovieDetailsRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val movieDetailsDataModule = module {

    factory<MovieDetailsRepository> { MovieDetailsRepositoryImpl(movieDetailsRemoteDataSource = get()) }

    factory<MovieDetailsRemoteDataSource> { MovieDetailsRemoteDataSourceImpl(movieDetailsApiService = get()) }

    factory { get<Retrofit>().create(MovieDetailsApiService::class.java) }
}