package com.RaphaelAGN.chucknorrisapp.endpoint

import com.RaphaelAGN.chucknorrisapp.models.JokeModel
import retrofit2.http.GET

interface JokeService {
    @GET("random")
    suspend fun getJoke(): JokeModel
}