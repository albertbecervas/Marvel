package com.abecerra.marvel.scenes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abecerra.marvel.R
import com.abecerra.marvel_presentation.ui.characters.view.CharactersFragment

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        launchFragment()
    }

    private fun launchFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl,
                CharactersFragment()
            )
            .commit()
    }
}
