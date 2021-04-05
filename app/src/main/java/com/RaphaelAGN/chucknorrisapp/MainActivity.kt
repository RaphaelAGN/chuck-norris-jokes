package com.RaphaelAGN.chucknorrisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.RaphaelAGN.chucknorrisapp.endpoint.Endpoint
import com.RaphaelAGN.chucknorrisapp.data.JokeModel
import com.RaphaelAGN.chucknorrisapp.retrofitClient.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var jokeButton: Button? = null
    var jokeTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jokeTextView = findViewById(R.id.joke_text_view)

        jokeTextView?.text = "Click the button below to get a joke"

        jokeButton = findViewById(R.id.joke_button)
        jokeButton?.text="New Joke"

        jokeButton?.setOnClickListener(){
            getRandomJoke();
        }
    }

    fun getRandomJoke() {
        val retrofitClient =
            RetrofitClient.getRetrofitInstance("https://api.chucknorris.io/jokes/");

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getJoke()

        callback.enqueue(object : Callback<JokeModel> {
            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                Toast.makeText(baseContext, "An error has occurred", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                jokeTextView?.text = response.body()?.value.toString()
            }
        })
    }

}