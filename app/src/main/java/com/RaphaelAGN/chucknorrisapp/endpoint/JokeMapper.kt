package com.RaphaelAGN.chucknorrisapp.endpoint

import com.RaphaelAGN.chucknorrisapp.domain.models.Joke
import com.RaphaelAGN.chucknorrisapp.models.JokeModel

object JokeMapper {
    fun toDomain(jokeModel: JokeModel) : Joke {
        return Joke(
                value = jokeModel.value
        )
    }
}