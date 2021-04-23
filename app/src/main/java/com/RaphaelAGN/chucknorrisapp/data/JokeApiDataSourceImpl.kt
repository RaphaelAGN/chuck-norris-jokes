package com.RaphaelAGN.chucknorrisapp.data

import com.RaphaelAGN.chucknorrisapp.endpoint.JokeService

class JokeApiDataSourceImpl(private val jokeService: JokeService) : JokeApiDataSource {
    override suspend fun getJoke() = jokeService.getJoke()
}