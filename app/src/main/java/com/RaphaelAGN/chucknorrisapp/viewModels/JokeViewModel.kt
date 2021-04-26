package com.RaphaelAGN.chucknorrisapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JokeViewModel(
        val chuckNorrisJokeRepository : ChuckNorrisJokeRepository
) : ViewModel() {

    val currentJoke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getRandomJoke() {

        CoroutineScope(Dispatchers.IO).launch {

            val joke = chuckNorrisJokeRepository.getApiJoke()
            withContext(Dispatchers.Main){
                currentJoke.value = joke.value
            }
        }
    }
}

