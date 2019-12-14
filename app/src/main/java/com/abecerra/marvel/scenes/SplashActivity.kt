package com.abecerra.marvel.scenes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abecerra.marvel.R
import com.abecerra.marvel.navigation.navigator.Navigator
import com.abecerra.marvel.navigation.navigator.Navigator.replaceFragment
import com.abecerra.marvel_presentation.ui.characters.view.CharactersFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        launchFragment()
    }

    private fun launchFragment() {
        replaceFragment(CharactersFragment())
    }
}
