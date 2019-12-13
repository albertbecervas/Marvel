package com.abecerra.marvel_presentation.ui.characters

import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.usecase.GetCharactersUseCase
import com.abecerra.marvel_presentation.base.BaseViewModel

class CharactersViewModel(private val getCharactersUseCase: GetCharactersUseCase) :
    BaseViewModel() {

    private val offset = 0

    fun getCharacters() {
        getCharactersUseCase.execute(
            params = GetCharactersUseCase.Params(offset),
            error = ::handleError,
            response = ::handleCharactersResponse
        )
    }

    private fun handleCharactersResponse(characters: List<Character>) {
        val response = characters
    }
}