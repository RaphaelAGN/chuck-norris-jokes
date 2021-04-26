package com.RaphaelAGN.chucknorrisapp.data

import com.RaphaelAGN.chucknorrisapp.models.JokeModel
import retrofit2.Call

interface JokeApiDataSource {
    suspend fun getApiJoke() : Call<JokeModel>
}