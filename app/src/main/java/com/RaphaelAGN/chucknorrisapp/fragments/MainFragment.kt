package com.RaphaelAGN.chucknorrisapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.idling.CountingIdlingResource
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.RaphaelAGN.chucknorrisapp.R
import com.RaphaelAGN.chucknorrisapp.viewModels.JokeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.fragment_main) {
    var jokeButton: Button? = null
    var jokeTextView: TextView? = null
    val TAG = "chuck_norris_app"

    val model: JokeViewModel by viewModel()

    val buttonText = "New Joke"
    val defaultTextOnTextView = "Click the button below to show a joke"

    private val idlingResource = CountingIdlingResource("MainFragment")
    fun getIdlingResource(): CountingIdlingResource? = idlingResource

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
            model.getRandomJoke()
            idlingResource.increment()
        }

        model.currentJoke.observe(viewLifecycleOwner, {
            jokeTextView?.text = it
            if (!idlingResource.isIdleNow) idlingResource.decrement()
        })

        model.error.observe(viewLifecycleOwner, {
            Toast.makeText(context,  it, Toast.LENGTH_LONG).show()
        })

        return root
    }
}