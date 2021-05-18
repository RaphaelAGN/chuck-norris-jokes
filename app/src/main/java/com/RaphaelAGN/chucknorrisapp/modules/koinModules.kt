package com.RaphaelAGN.chucknorrisapp.modules

import com.RaphaelAGN.chucknorrisapp.core.CoroutineContextProvider
import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSource
import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSourceImpl
import com.RaphaelAGN.chucknorrisapp.domain.interactors.GetJokeUseCase
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepositoryImpl
import com.RaphaelAGN.chucknorrisapp.retrofitClient.RetrofitClient
import com.RaphaelAGN.chucknorrisapp.viewModels.JokeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val jokeViewModelModule =
    module {
        viewModel { JokeViewModel(androidApplication(), get()) }
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

val jokeUseCaseModule =
        module {
            factory {
                GetJokeUseCase(
                    chuckNorrisJokeRepository = get(),
                    coroutineContextProvider = get()
                )
            }
        }

val coroutineContextProvider =
    module {
        single { CoroutineContextProvider() }
    }