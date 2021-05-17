package com.RaphaelAGN.chucknorrisapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.RaphaelAGN.chucknorrisapp.domain.interactors.GetJokeUseCase

class JokeViewModel(
        application: Application,
        private val jokeUseCase: GetJokeUseCase
) : AndroidViewModel(application) {

    val currentJoke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getRandomJoke() {
        jokeUseCase(
            scope = viewModelScope,
            onSuccess = {
                currentJoke.value = it.value
            },
            onError = {
                error.value = it.message
            }
        )

    }
}

