package com.abecerra.marvel_presentation.ui.characters

import com.abecerra.marvel_presentation.base.BaseRouter

interface CharactersRouter : BaseRouter {
    fun onCharacterClick(id: Int)
}