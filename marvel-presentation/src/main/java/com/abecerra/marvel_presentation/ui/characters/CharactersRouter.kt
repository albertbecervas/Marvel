package com.abecerra.marvel_presentation.ui.characters

import com.abecerra.marvel_presentation.base.BaseRouter
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModel

interface CharactersRouter : BaseRouter {
    fun onCharacterClick(characterModel: CharacterModel)
}