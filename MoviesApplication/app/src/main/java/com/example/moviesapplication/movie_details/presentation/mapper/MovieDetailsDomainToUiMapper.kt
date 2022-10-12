package com.example.moviesapplication.movie_details.presentation.mapper

import com.example.moviesapplication.core.mapper.Mapper
import com.example.moviesapplication.movie_details.domain.model.MovieDetailsDomainModel
import com.example.moviesapplication.movie_details.presentation.model.MovieDetailsUiModel

class MovieDetailsDomainToUiMapper : Mapper<MovieDetailsDomainModel, MovieDetailsUiModel> {

    override fun map(inputModel: MovieDetailsDomainModel): MovieDetailsUiModel =
        MovieDetailsUiModel(
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