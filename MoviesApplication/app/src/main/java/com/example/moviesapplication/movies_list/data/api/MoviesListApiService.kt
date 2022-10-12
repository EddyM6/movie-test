package com.example.moviesapplication.movies_list.data.api

import com.example.moviesapplication.movies_list.data.model.MoviesListDataModel
import retrofit2.http.GET

interface MoviesListApiService {

    @GET("3/discover/movie")
    suspend fun getMoviesList(): MoviesListDataModel
}