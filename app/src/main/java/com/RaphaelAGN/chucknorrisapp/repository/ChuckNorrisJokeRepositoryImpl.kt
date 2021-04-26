package com.RaphaelAGN.chucknorrisapp.repository

import com.RaphaelAGN.chucknorrisapp.data.JokeApiDataSource

class ChuckNorrisJokeRepositoryImpl(private val jokeApiDataSource: JokeApiDataSource)
    : ChuckNorrisJokeRepository {
    override suspend fun getApiJoke() = jokeApiDataSource.getJoke()
}