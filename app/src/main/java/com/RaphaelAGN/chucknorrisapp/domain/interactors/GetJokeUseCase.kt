package com.RaphaelAGN.chucknorrisapp.domain.interactors

import com.RaphaelAGN.chucknorrisapp.core.CoroutineContextProvider
import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import kotlinx.coroutines.*
import java.lang.Exception
import java.net.UnknownHostException

class GetJokeUseCase(
        private val chuckNorrisJokeRepository: ChuckNorrisJokeRepository,
        private val coroutineContextProvider: CoroutineContextProvider
) {

    operator fun invoke(
        onSuccess: (joke : Joke) -> Unit = {},
        onError: (throwable : Throwable) -> Unit = {}
    ) {
        runBlocking(coroutineContextProvider.io) {
            try {
                val joke = chuckNorrisJokeRepository.getApiJoke()
                withContext(coroutineContextProvider.main) {
                    onSuccess(joke)
                }
            } catch (e: Exception) {
                val errorMessage = when (e) {
                    is UnknownHostException -> {
                        "Não encontrado"
                    }
                    else -> {
                        "Erro genérico"
                    }
                }
                withContext(coroutineContextProvider.main) {
                    onError(Throwable(errorMessage))
                }
            }
        }
    }
}