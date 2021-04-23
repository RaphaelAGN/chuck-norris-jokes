package com.RaphaelAGN.chucknorrisapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.RaphaelAGN.chucknorrisapp.models.JokeModel
import com.RaphaelAGN.chucknorrisapp.repository.ChuckNorrisJokeRepositoryImpl
import com.RaphaelAGN.chucknorrisapp.retrofitClient.RetrofitClient
import org.koin.java.KoinJavaComponent.inject
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

        val callback = retrofitClient.getJoke()

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

