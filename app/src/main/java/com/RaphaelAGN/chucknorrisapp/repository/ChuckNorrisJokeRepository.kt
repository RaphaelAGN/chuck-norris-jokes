package com.RaphaelAGN.chucknorrisapp.repository

import com.RaphaelAGN.chucknorrisapp.domain.models.Joke

interface ChuckNorrisJokeRepository {
    suspend fun getApiJoke() : Joke
}