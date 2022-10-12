package com.example.moviesapplication.movie_details.data.repository

import com.example.moviesapplication.movie_details.data.model.MovieDetailsDataModel

interface MovieDetailsRepository {

    suspend fun getRemoteMovieDetails(movieId: Int): MovieDetailsDataModel
}