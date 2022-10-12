package com.example.moviesapplication

import android.app.Application
import com.example.moviesapplication.core.di.coroutineModule
import com.example.moviesapplication.core.di.networkModule
import com.example.moviesapplication.core.extension.d
import com.example.moviesapplication.movie_details.data.di.movieDetailsDataModule
import com.example.moviesapplication.movie_details.domain.di.movieDetailsDomainModule
import com.example.moviesapplication.movie_details.presentation.setup.di.movieDetailsPresentationModule
import com.example.moviesapplication.movies_list.data.setup.di.moviesListDataModule
import com.example.moviesapplication.movies_list.domain.setup.di.moviesListDomainModule
import com.example.moviesapplication.movies_list.presentation.setup.di.moviesListPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        d {
            "onCreate: SpeedTrackerApp!"
        }

        startKoin {
            androidLogger()
            androidContext(this@MoviesApplication)
            modules(
                listOf(
                    coroutineModule,
                    networkModule,
                    moviesListDataModule,
                    moviesListDomainModule,
                    moviesListPresentationModule,
                    movieDetailsDataModule,
                    movieDetailsDomainModule,
                    movieDetailsPresentationModule
                )
            )
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}