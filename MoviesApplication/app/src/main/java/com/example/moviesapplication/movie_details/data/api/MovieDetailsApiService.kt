package com.example.moviesapplication.movie_details.data.api

import com.example.moviesapplication.movie_details.data.model.MovieDetailsDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsApiService {

    @GET("3/movie/{movie_id}?")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int
    ): MovieDetailsDataModel
}