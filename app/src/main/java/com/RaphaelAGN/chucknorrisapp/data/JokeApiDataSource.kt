package com.RaphaelAGN.chucknorrisapp.data

import com.RaphaelAGN.chucknorrisapp.domain.models.Joke

interface JokeApiDataSource {
    suspend fun getJoke() : Joke
}