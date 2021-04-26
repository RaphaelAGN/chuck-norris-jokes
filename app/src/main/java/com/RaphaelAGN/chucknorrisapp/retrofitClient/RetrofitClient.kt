package com.RaphaelAGN.chucknorrisapp.retrofitClient

import com.RaphaelAGN.chucknorrisapp.endpoint.JokeService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        fun getRetrofitInstance(path: String) : JokeService {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(JokeService::class.java)
        }
    }
}