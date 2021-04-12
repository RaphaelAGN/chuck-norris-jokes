package com.RaphaelAGN.chucknorrisapp.viewModels

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.RaphaelAGN.chucknorrisapp.MainActivity
import com.RaphaelAGN.chucknorrisapp.R
import com.RaphaelAGN.chucknorrisapp.data.JokeModel
import com.RaphaelAGN.chucknorrisapp.endpoint.Endpoint
import com.RaphaelAGN.chucknorrisapp.fragments.MainFragment
import com.RaphaelAGN.chucknorrisapp.retrofitClient.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JokeViewModel : ViewModel() {

    val currentJoke: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getRandomJoke() {
        val retrofitClient =
            RetrofitClient.getRetrofitInstance("https://api.chucknorris.io/jokes/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getJoke()

        callback.enqueue(object : Callback<JokeModel> {
            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                error.value = "An error has occurred"
            }

            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                currentJoke.value = response.body()?.value.toString()
            }
        })
    }
}

