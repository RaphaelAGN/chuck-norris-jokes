package com.RaphaelAGN.chucknorrisapp.modules

import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSource
import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSourceImpl
import com.RaphaelAGN.chucknorrisapp.endpoint.JokeService
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepositoryImpl
import com.RaphaelAGN.chucknorrisapp.viewModels.JokeViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val jokeViewModelModule =
    module {
        single { JokeViewModel() }
    }

val retrofitJokeService = module {
    factory {
        Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io/jokes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JokeService::class.java)
    }
}

val repositoryModule =
        module {
            single<ChuckNorrisJokeRepository> { ChuckNorrisJokeRepositoryImpl(get()) }
        }

val dataSourceModule =
        module {
            single<JokeApiDataSource> { JokeApiDataSourceImpl(get()) }
        }