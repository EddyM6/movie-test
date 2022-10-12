package com.example.moviesapplication.movies_list.data.repository.impl

import com.example.moviesapplication.movies_list.data.data_source.remote.MoviesListRemoteDataSource
import com.example.moviesapplication.movies_list.data.model.MoviesListDataModel
import com.example.moviesapplication.movies_list.data.repository.MoviesListRepository

class MoviesListRepositoryImpl(
    private val moviesListRemoteDataSource: MoviesListRemoteDataSource,
) : MoviesListRepository {

    override suspend fun getRemoteMoviesList(): MoviesListDataModel =
        moviesListRemoteDataSource.getMoviesList()
}