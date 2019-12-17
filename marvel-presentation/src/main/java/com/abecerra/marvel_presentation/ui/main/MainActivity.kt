package com.abecerra.marvel_presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.base.BaseToolbarActivity
import com.abecerra.marvel_presentation.navigation.navigator.Navigator.replaceFragment
import com.abecerra.marvel_presentation.ui.characters.view.CharactersFragment

class MainActivity : BaseToolbarActivity() {
    override fun getLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        replaceFragment(CharactersFragment())
    }
}
