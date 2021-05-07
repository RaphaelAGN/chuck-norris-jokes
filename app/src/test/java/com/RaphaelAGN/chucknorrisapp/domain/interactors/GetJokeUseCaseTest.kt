package com.RaphaelAGN.chucknorrisapp.domain.interactors

import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import io.kotest.matchers.ints.exactly
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.lang.Exception
import java.net.UnknownHostException

class GetJokeUseCaseTest {
    val chuckNorrisJokeRepository : ChuckNorrisJokeRepository = mockk(relaxed = true)
    val onSuccess : (joke : Joke) -> Unit = mockk(relaxed = true)
    val onError : (throwable : Throwable) -> Unit = mockk(relaxed = true)

    @Test
    fun `GIVEN jokeUseCase WHEN jokeUseCase is called THEN with success, repository and onSuccess are called`() {
        runBlocking {
            //GIVEN
            val jokeUseCase = GetJokeUseCase(chuckNorrisJokeRepository)
            val joke = Joke("joke")
            coEvery { chuckNorrisJokeRepository.getApiJoke() } returns joke

            //WHEN
            jokeUseCase(onSuccess)

            //THEN
            coVerify(exactly = 1) { chuckNorrisJokeRepository.getApiJoke() }
            coVerify(exactly = 1) { onSuccess(joke) }
        }
    }

    @Test
    fun `GIVEN jokeUseCase WHEN an UnknownHostException occurs THEN this exception MUST be thrown`(){
        //GIVEN
        val jokeUseCase = GetJokeUseCase(chuckNorrisJokeRepository)
        coEvery { chuckNorrisJokeRepository.getApiJoke() } throws UnknownHostException()

        //WHEN
        jokeUseCase(onSuccess, onError)

        //THEN
        verify(exactly = 1) { onError(any()) }
    }

    @Test
    fun `GIVEN jokeUseCase WHEN an error occurs THEN an exception MUST be thrown`(){
        //GIVEN
        val jokeUseCase = GetJokeUseCase(chuckNorrisJokeRepository)
        coEvery { chuckNorrisJokeRepository.getApiJoke() } throws Exception()

        //WHEN
        jokeUseCase(onSuccess, onError)

        //THEN
        verify(exactly = 1) { onError(any()) }
    }
}