package com.example.moviesapplication.core.di

import com.example.moviesapplication.BuildConfig
import com.example.moviesapplication.core.network.OkHttpProvider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    single {
        OkHttpProvider()
    }

    single {

        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.MOVIES_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(get<OkHttpProvider>())
                    .build()
            )
            .build()
    }
}