package com.RaphaelAGN.chucknorrisapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.RaphaelAGN.chucknorrisapp.R
import com.RaphaelAGN.chucknorrisapp.data.JokeModel
import com.RaphaelAGN.chucknorrisapp.endpoint.Endpoint
import com.RaphaelAGN.chucknorrisapp.retrofitClient.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment(R.layout.fragment_main) {
    var jokeButton: Button? = null
    var jokeTextView: TextView? = null
    val TAG = "chuck_norris_app"

    val buttonText = "New Joke"
    val defaultTextOnTextView = "Click the button below to show a joke"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateViewFragment")
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        jokeTextView = root.findViewById(R.id.joke_text_view)

        jokeTextView?.text = defaultTextOnTextView

        jokeButton = root.findViewById(R.id.joke_button)
        jokeButton?.text = buttonText

        jokeButton?.setOnClickListener(){
            getRandomJoke()
        }

        return root
    }

    fun getRandomJoke() {
        val retrofitClient =
                RetrofitClient.getRetrofitInstance("https://api.chucknorris.io/jokes/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getJoke()

        callback.enqueue(object : Callback<JokeModel> {
            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                Toast.makeText(context, "An error has occurred", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                jokeTextView?.text = response.body()?.value.toString()
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreateFragment")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, "onAttachFragment")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStartFragment")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResumeFragment")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPauseFragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroyFragment")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStopFragment")
    }
}