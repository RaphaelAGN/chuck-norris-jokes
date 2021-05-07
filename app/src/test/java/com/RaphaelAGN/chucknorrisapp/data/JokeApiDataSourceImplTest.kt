package com.RaphaelAGN.chucknorrisapp.data

import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import com.RaphaelAGN.chucknorrisapp.endpoint.JokeMapper
import com.RaphaelAGN.chucknorrisapp.endpoint.JokeService
import com.RaphaelAGN.chucknorrisapp.models.JokeModel
import io.kotest.matchers.shouldBe
import io.mockk.*
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.lang.Exception

class JokeApiDataSourceImplTest {

    val jokeService : JokeService = mockk()

    @Test
    fun `GIVEN jokeApiDataSource WHEN getJoke called the return of getJoke is a joke value`() {
        runBlocking {
            //GIVEN
            val dataSource = JokeApiDataSourceImpl(jokeService)
            val joke = Joke("joke")
            coEvery { jokeService.getJoke() } returns JokeModel("", "", "", "joke")

            //WHEN
            val result = dataSource.getJoke()

            //THEN
            result.value shouldBe joke.value
        }
    }

    @Test(expected = Exception::class)
    fun `GIVEN jokeApiDataSource WHEN getJoke service called if an error occurs an exception MUST be thrown`() {
        runBlocking {
            //GIVEN
            val dataSource = JokeApiDataSourceImpl(jokeService)
            coEvery { jokeService.getJoke() } throws Exception()

            //WHEN
            dataSource.getJoke()

            //THEN
            //Exception expected
        }
    }
}