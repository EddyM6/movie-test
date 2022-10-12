package com.example.moviesapplication.movies_list.presentation.mapper

import com.example.moviesapplication.core.mapper.Mapper
import com.example.moviesapplication.movies_list.domain.model.MoviesListDomainModel
import com.example.moviesapplication.movies_list.presentation.model.MoviesListUiModel

class MoviesListDomainToUiMapper : Mapper<MoviesListDomainModel, MoviesListUiModel> {

    override fun map(inputModel: MoviesListDomainModel): MoviesListUiModel =
        MoviesListUiModel(
            page = inputModel.page,
            results = inputModel.results?.map { model ->
                ResultMapper().map(
                    model
                )
            },
            total_pages = inputModel.total_pages,
            total_results = inputModel.total_results
        )

    inner class ResultMapper : Mapper<MoviesListDomainModel.Result?, MoviesListUiModel.Result?> {

        override fun map(inputModel: MoviesListDomainModel.Result?): MoviesListUiModel.Result =
            MoviesListUiModel.Result(
                adult = inputModel?.adult,
                id = inputModel?.id,
                poster_path = inputModel?.poster_path,
                release_date = inputModel?.release_date,
                title = inputModel?.title,
                vote_average = inputModel?.vote_average,
                vote_count = inputModel?.vote_count
            )
    }
}