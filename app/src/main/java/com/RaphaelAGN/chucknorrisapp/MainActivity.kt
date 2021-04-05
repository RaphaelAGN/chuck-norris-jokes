package com.RaphaelAGN.chucknorrisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.*
import com.RaphaelAGN.chucknorrisapp.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    val manager: FragmentManager = supportFragmentManager
    val transaction: FragmentTransaction = manager.beginTransaction()
    val TAG = "chuck_norris_app"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) {
            val fragment = MainFragment()
            transaction.replace(R.id.main_fragment, fragment)
            transaction.commit()
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

}