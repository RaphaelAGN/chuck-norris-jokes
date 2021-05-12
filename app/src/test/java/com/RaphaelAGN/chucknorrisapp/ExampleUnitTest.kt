package com.RaphaelAGN.chucknorrisapp

import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSource
import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val jokeApiDataSource : JokeApiDataSource = mockk(relaxed = true)
    val joke : Joke = mockk()

    @Test
    fun addition_isCorrect () {
        assertEquals(4, 2+2)
    }

    @Test
    fun `WHEN jokeApiDataSource`() {
        runBlocking {
            //GIVEN
            val dataSource = jokeApiDataSource
            coEvery { dataSource.getJoke() } returns joke

            //WHEN
            val result = dataSource.getJoke()

            //THEN
            assertEquals(joke, result)
        }
    }

}