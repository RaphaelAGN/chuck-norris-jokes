package com.RaphaelAGN.chucknorrisapp.modules

import com.RaphaelAGN.chucknorrisapp.viewModels.JokeViewModel
import org.koin.dsl.module

val jokeViewModelModule =
    module {
        single { JokeViewModel() }
    }