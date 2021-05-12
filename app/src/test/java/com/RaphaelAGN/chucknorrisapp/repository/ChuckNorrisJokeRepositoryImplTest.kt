package com.RaphaelAGN.chucknorrisapp.repository

import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSource
import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import io.kotest.matchers.shouldBe
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class ChuckNorrisJokeRepositoryImplTest {

    val jokeApiDataSource : JokeApiDataSource = mockk(relaxed = true)

    @Test
    fun `GIVEN chuckNorrisJokeRepository WHEN apiJoke requested THEN getApiJoke MUST be called`() {
        runBlocking {
            //GIVEN
            val repository = ChuckNorrisJokeRepositoryImpl(jokeApiDataSource)

            //WHEN
            repository.getApiJoke()

            //THEN
            coVerify(exactly = 1) { jokeApiDataSource.getJoke() }
        }
    }

    @Test(expected = Exception::class)
    fun `GIVEN chuckNorrisJokeRepository WHEN getApiJoke called if an error occurs an exception MUST be thrown`() {
        runBlocking {
            //GIVEN
            val repository = ChuckNorrisJokeRepositoryImpl(jokeApiDataSource)
            coEvery { jokeApiDataSource.getJoke() } throws Exception()

            //WHEN
            repository.getApiJoke()

            //THEN
            //Expected exception
        }
    }
}