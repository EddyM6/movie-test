package com.example.moviesapplication.movie_details.data.repository.impl

import com.example.moviesapplication.movie_details.data.model.MovieDetailsDataModel
import com.example.moviesapplication.movie_details.data.remote.MovieDetailsRemoteDataSource
import com.example.moviesapplication.movie_details.data.repository.MovieDetailsRepository

class MovieDetailsRepositoryImpl(
    private val movieDetailsRemoteDataSource: MovieDetailsRemoteDataSource,
) : MovieDetailsRepository {

    override suspend fun getRemoteMovieDetails(movieId: Int): MovieDetailsDataModel =
        movieDetailsRemoteDataSource.getMovieDetails(movieId)
}