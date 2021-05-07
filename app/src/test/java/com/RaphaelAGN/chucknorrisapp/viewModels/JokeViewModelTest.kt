package com.RaphaelAGN.chucknorrisapp.viewModels

import com.RaphaelAGN.chucknorrisapp.domain.interactors.GetJokeUseCase
import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import io.kotest.matchers.ints.exactly
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class JokeViewModelTest {
    val jokeUseCase : GetJokeUseCase = mockk(relaxed = true)
    val onSuccess : (joke : Joke) -> Unit = mockk()
    val onError : (throwable : Throwable) -> Unit = mockk()

    @Test
    fun `GIVEN jokeViewModel WHEN getRandomJoke called THEN jokeUseCase called`() {
        //GIVEN
        val jokeViewModel = JokeViewModel(jokeUseCase)

        //WHEN
        jokeViewModel.getRandomJoke()

        //THEN
        verify(exactly = 1) { jokeUseCase(any(), any())}
    }

    @Test
    fun `asas`() {
        //GIVEN
        val jokeViewModel = JokeViewModel(jokeUseCase)

        //WHEN
        jokeViewModel.getRandomJoke()

        //THEN
        verify {  }
    }
}