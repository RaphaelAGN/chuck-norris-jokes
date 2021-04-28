package com.RaphaelAGN.chucknorrisapp

import android.app.Application
import com.RaphaelAGN.chucknorrisapp.modules.dataSourceModule
import com.RaphaelAGN.chucknorrisapp.modules.jokeViewModelModule
import com.RaphaelAGN.chucknorrisapp.modules.repositoryModule
import com.RaphaelAGN.chucknorrisapp.modules.retrofitJokeService
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
                    jokeViewModelModule
                )
            )
        }
    }
}