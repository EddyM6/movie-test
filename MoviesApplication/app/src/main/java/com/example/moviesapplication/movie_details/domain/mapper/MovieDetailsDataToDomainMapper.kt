package com.example.moviesapplication.movie_details.domain.mapper

import com.example.moviesapplication.core.mapper.Mapper
import com.example.moviesapplication.movie_details.data.model.MovieDetailsDataModel
import com.example.moviesapplication.movie_details.domain.model.MovieDetailsDomainModel

class MovieDetailsDataToDomainMapper : Mapper<MovieDetailsDataModel, MovieDetailsDomainModel> {

    override fun map(inputModel: MovieDetailsDataModel): MovieDetailsDomainModel =
        MovieDetailsDomainModel(
            adult = inputModel.adult,
            id = inputModel.id,
            overview = inputModel.overview,
            poster_path = inputModel.poster_path,
            release_date = inputModel.release_date,
            title = inputModel.title,
            vote_average = inputModel.vote_average,
            vote_count = inputModel.vote_count
        )
}