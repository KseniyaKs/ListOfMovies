package com.example.listofmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listofmovies.movies_screen.ui.MoviesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, MoviesFragment.newInstance())
                .commit()
        }
    }
}