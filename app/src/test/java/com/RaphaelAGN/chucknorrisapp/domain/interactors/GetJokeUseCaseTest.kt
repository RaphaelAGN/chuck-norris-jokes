package com.RaphaelAGN.chucknorrisapp.domain.interactors

import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepository
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test
import java.lang.Exception

class GetJokeUseCaseTest {
    val chuckNorrisJokeRepository : ChuckNorrisJokeRepository = mockk(relaxed = true)

    @Test(expected = Exception::class)
    fun `GIVEN test`() {

    }
}