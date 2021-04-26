package com.RaphaelAGN.chucknorrisapp.repository

import com.RaphaelAGN.chucknorrisapp.models.JokeModel
import retrofit2.Call

interface ChuckNorrisJokeRepository {
    suspend fun getApiJoke() : JokeModel
}