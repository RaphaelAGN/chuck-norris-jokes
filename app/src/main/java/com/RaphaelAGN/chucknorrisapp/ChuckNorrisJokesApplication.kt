package com.RaphaelAGN.chucknorrisapp

import android.app.Application
import com.RaphaelAGN.chucknorrisapp.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ChuckNorrisJokesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ChuckNorrisJokesApplication)
            modules(
                listOf(
                    retrofitJokeService,
                    dataSourceModule,
                    repositoryModule,
                    jokeUseCaseModule,
                    jokeViewModelModule,
                    coroutineContextProvider
                )
            )
        }
    }
}