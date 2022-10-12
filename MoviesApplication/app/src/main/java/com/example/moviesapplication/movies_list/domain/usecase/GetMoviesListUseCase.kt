package com.example.moviesapplication.movies_list.domain.usecase

import com.example.moviesapplication.core.usecase.CoroutineUseCase
import com.example.moviesapplication.movie_details.data.repository.MovieDetailsRepository
import com.example.moviesapplication.movie_details.domain.mapper.MovieDetailsDataToDomainMapper
import com.example.moviesapplication.movie_details.domain.model.MovieDetailsDomainModel
import com.example.moviesapplication.movies_list.data.repository.MoviesListRepository
import com.example.moviesapplication.movies_list.domain.mapper.MoviesListDataToDomainMapper
import com.example.moviesapplication.movies_list.domain.model.MoviesListDomainModel
import kotlinx.coroutines.CoroutineDispatcher

class GetMoviesListUseCase(
    coroutineDispatcher: CoroutineDispatcher,
    private val moviesListDataToDomainMapper: MoviesListDataToDomainMapper,
    private val moviesListRepository: MoviesListRepository
) : CoroutineUseCase<Unit, MoviesListDomainModel>(coroutineDispatcher = coroutineDispatcher) {

    override suspend fun execute(parameters: Unit): MoviesListDomainModel =
        moviesListDataToDomainMapper.map(moviesListRepository.getRemoteMoviesList())
}