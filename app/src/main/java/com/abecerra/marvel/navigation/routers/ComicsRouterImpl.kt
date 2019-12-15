package com.abecerra.marvel.navigation.routers

import android.content.Context
import com.abecerra.comics.ComicsRouter
import com.abecerra.marvel.navigation.navigator.Navigator.replaceFragment
import com.abecerra.marvel_presentation.ui.characters.view.CharactersFragment

class ComicsRouterImpl(private val context: Context?) : ComicsRouter {
    override fun nav() {
        context?.replaceFragment(CharactersFragment())
    }
}