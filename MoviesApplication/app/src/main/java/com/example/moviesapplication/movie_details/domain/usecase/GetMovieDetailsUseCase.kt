package com.example.moviesapplication.movie_details.domain.usecase

import com.example.moviesapplication.core.usecase.CoroutineUseCase
import com.example.moviesapplication.movie_details.data.repository.MovieDetailsRepository
import com.example.moviesapplication.movie_details.domain.mapper.MovieDetailsDataToDomainMapper
import com.example.moviesapplication.movie_details.domain.model.MovieDetailsDomainModel
import kotlinx.coroutines.CoroutineDispatcher

class GetMovieDetailsUseCase(
    coroutineDispatcher: CoroutineDispatcher,
    private val movieDetailsDataToDomainMapper: MovieDetailsDataToDomainMapper,
    private val movieDetailsRepository: MovieDetailsRepository
) : CoroutineUseCase<Int, MovieDetailsDomainModel>(coroutineDispatcher = coroutineDispatcher) {

    override suspend fun execute(parameters: Int): MovieDetailsDomainModel =
        movieDetailsDataToDomainMapper.map(
            movieDetailsRepository.getRemoteMovieDetails(parameters)
        )
}