package com.RaphaelAGN.chucknorrisapp

import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSource
import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import com.RaphaelAGN.chucknorrisapp.viewModels.JokeViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val chuckNorrisJokeRepository : ChuckNorrisJokeRepository =  mockk(relaxed = true)
    val jokeApiDataSource : JokeApiDataSource = mockk(relaxed = true)
    val jokeViewModel : JokeViewModel = mockk()
    val joke : Joke = mockk()

    @Test
    fun addition_isCorrect () {
        assertEquals(4, 2+2)
    }

    @Test
    fun `WHEN chuckNorrisJokeRepository`() {
        runBlocking {
            //GIVEN
            val repository = chuckNorrisJokeRepository
            coEvery { repository.getApiJoke() } returns joke

            //WHEN
            val result = repository.getApiJoke()

            //THEN
            assertEquals(joke, result)
        }
    }

    @Test
    fun `WHEN jokeApiDataSource`() {
        runBlocking {
            //GIVEN
            val dataSource = jokeApiDataSource
            coEvery { dataSource.getJoke() } returns joke

            val result = dataSource.getJoke()

            assertEquals(joke, result)
        }
    }

}