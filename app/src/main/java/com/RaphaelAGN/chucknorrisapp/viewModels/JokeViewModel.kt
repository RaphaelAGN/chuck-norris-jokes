package com.RaphaelAGN.chucknorrisapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.RaphaelAGN.chucknorrisapp.domain.interactors.GetJokeUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class JokeViewModel : ViewModel(), KoinComponent {

    val jokeUseCase: GetJokeUseCase by inject()

    val currentJoke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getRandomJoke() {
        jokeUseCase(
            onSuccess = {
                currentJoke.value = it.value
            },
            onError = {
                error.value = it.message
            }
        )
    }
}

