package com.abecerra.marvel.navigation.routers

import android.content.Context
import com.abecerra.comics.ComicsFragment
import com.abecerra.marvel.navigation.navigator.Navigator.replaceFragment
import com.abecerra.marvel_presentation.ui.characters.CharactersRouter

class CharactersRouterImpl(private var context: Context?) : CharactersRouter {
    override fun onCharacterClick(id: Int) {
        context?.replaceFragment(ComicsFragment())
    }

    override fun unAttach() {
        this.context = null
    }
}