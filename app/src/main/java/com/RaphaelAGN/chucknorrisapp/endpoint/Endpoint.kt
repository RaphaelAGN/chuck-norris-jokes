package com.RaphaelAGN.chucknorrisapp.endpoint

import com.RaphaelAGN.chucknorrisapp.data.JokeModel
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("random")
    fun getJoke(): Call<JokeModel>
}