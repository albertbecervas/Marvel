package com.abecerra.marvel_presentation.ui.characterdetail

import com.abecerra.marvel_presentation.base.BaseRouter

interface CharactersDetailRouter : BaseRouter{

    fun onComicsClick()

    fun onEventsClick()

    fun onMoviesClick()
}