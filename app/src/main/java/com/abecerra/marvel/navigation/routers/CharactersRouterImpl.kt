package com.abecerra.marvel.navigation.routers

import android.content.Context
import com.abecerra.marvel.navigation.navigator.Navigator.replaceFragment
import com.abecerra.marvel_presentation.ui.characterdetail.view.CharacterDetailFragment
import com.abecerra.marvel_presentation.ui.characters.CharactersRouter

class CharactersRouterImpl(private var context: Context?) : CharactersRouter {
    override fun onCharacterClick(id: Int) {
        context?.replaceFragment(CharacterDetailFragment.newInstance(id))
    }

    override fun unAttach() {
        this.context = null
    }
}