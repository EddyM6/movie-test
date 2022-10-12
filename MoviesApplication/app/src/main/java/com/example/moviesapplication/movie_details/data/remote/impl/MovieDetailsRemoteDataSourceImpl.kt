package com.example.moviesapplication.movie_details.data.remote.impl

import com.example.moviesapplication.movie_details.data.api.MovieDetailsApiService
import com.example.moviesapplication.movie_details.data.model.MovieDetailsDataModel
import com.example.moviesapplication.movie_details.data.remote.MovieDetailsRemoteDataSource

class MovieDetailsRemoteDataSourceImpl(
    private val movieDetailsApiService: MovieDetailsApiService
) : MovieDetailsRemoteDataSource {

    override suspend fun getMovieDetails(movieId: Int): MovieDetailsDataModel =
        movieDetailsApiService.getMovieDetails(movieId)
}