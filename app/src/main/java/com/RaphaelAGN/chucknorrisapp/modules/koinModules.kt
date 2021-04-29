package com.RaphaelAGN.chucknorrisapp.modules

import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSource
import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSourceImpl
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepositoryImpl
import com.RaphaelAGN.chucknorrisapp.retrofitClient.RetrofitClient
import com.RaphaelAGN.chucknorrisapp.viewModels.JokeViewModel
import org.koin.dsl.module

val jokeViewModelModule =
    module {
        single { JokeViewModel(get()) }
    }

val retrofitJokeService = module {
    factory {
        RetrofitClient.getRetrofitInstance("https://api.chucknorris.io/jokes/")
    }
}

val repositoryModule =
        module {
            factory<ChuckNorrisJokeRepository> { ChuckNorrisJokeRepositoryImpl(get()) }
        }

val dataSourceModule =
        module {
            factory<JokeApiDataSource> { JokeApiDataSourceImpl(get()) }
        }