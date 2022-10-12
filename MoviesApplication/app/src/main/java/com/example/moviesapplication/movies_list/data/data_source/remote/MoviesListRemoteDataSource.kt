package com.example.moviesapplication.movies_list.data.data_source.remote

import com.example.moviesapplication.movies_list.data.model.MoviesListDataModel

interface MoviesListRemoteDataSource {

    suspend fun getMoviesList(): MoviesListDataModel
}