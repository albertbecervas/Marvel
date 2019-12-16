package com.abecerra.marvel.navigation.routers

import android.content.Context
import com.abecerra.marvel_presentation.ui.characterdetail.CharactersDetailRouter

class CharacterDetailRouterImpl(private var context: Context?) : CharactersDetailRouter {
    override fun onComicsClick() {
    }

    override fun onEventsClick() {
    }

    override fun onMoviesClick() {
    }

    override fun unAttach() {
        this.context = null
    }
}