package com.RaphaelAGN.chucknorrisapp.viewModels

import android.app.Application
import com.RaphaelAGN.chucknorrisapp.domain.interactors.GetJokeUseCase
import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import io.kotest.matchers.shouldBe
import io.mockk.*
import org.junit.Test
import org.mockito.ArgumentMatchers.any

class JokeViewModelTest {
    val jokeUseCase : GetJokeUseCase = mockk(relaxed = true)
    val application: Application = mockk(relaxed = true)

    @Test
    fun `GIVEN jokeViewModel WHEN getRandomJoke called THEN jokeUseCase called`() {
        //GIVEN
        val jokeViewModel = JokeViewModel(application, jokeUseCase)

        //WHEN
        jokeViewModel.getRandomJoke()

        //THEN
        verify(exactly = 1) { jokeUseCase(any(), any(), any())}
    }

    @Test
    fun `testing `() {
        // GIVEN
        val jokeViewModel = JokeViewModel(application, jokeUseCase)
        val joke = Joke("joke")
        every {
            jokeUseCase.invoke(
                scope = any(),
                onSuccess = captureLambda(),
                onError = any()
            )
        } answers { lambda<(Joke) -> Unit>().invoke(joke) }
        // WHEN
        jokeViewModel.getRandomJoke()
        // THEN
        jokeViewModel.currentJoke.value shouldBe joke.value
    }





    @Test
    fun `testing error`() {
        // GIVEN
        val jokeViewModel = JokeViewModel(application, jokeUseCase)
        val messageError = Throwable("erro")
        every {
            jokeUseCase.invoke(
                scope = any(),
                onSuccess = any(),
                onError = captureLambda()
            )
        } answers { lambda<(Throwable) -> Unit>().invoke(messageError) }
        // WHEN
        jokeViewModel.getRandomJoke()
        // THEN
        jokeViewModel.error.value shouldBe messageError.message
    }
}