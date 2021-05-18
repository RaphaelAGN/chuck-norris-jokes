package com.RaphaelAGN.chucknorrisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.RaphaelAGN.chucknorrisapp.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    val fragment = MainFragment()
    val TAG = "chuck_norris_app"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment, fragment)
                .commit()
        }
    }
}