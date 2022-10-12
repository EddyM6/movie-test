package com.example.moviesapplication.movies_list.domain.mapper

import com.example.moviesapplication.core.mapper.Mapper
import com.example.moviesapplication.movies_list.data.model.MoviesListDataModel
import com.example.moviesapplication.movies_list.domain.model.MoviesListDomainModel

class MoviesListDataToDomainMapper : Mapper<MoviesListDataModel, MoviesListDomainModel> {

    override fun map(inputModel: MoviesListDataModel): MoviesListDomainModel =
        MoviesListDomainModel(
            page = inputModel.page,
            results = inputModel.results?.map { model ->
                ResultMapper().map(
                    model
                )
            },
            total_pages = inputModel.total_pages,
            total_results = inputModel.total_results
        )

    inner class ResultMapper :
        Mapper<MoviesListDataModel.Result?, MoviesListDomainModel.Result?> {

        override fun map(inputModel: MoviesListDataModel.Result?): MoviesListDomainModel.Result =
            MoviesListDomainModel.Result(
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