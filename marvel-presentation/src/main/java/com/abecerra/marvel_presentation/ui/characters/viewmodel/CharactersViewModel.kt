package com.abecerra.marvel_presentation.ui.characters.viewmodel

import androidx.lifecycle.MutableLiveData
import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.usecase.GetCharactersUseCase
import com.abecerra.marvel_presentation.base.BaseViewModel
import com.abecerra.marvel_presentation.ui.characters.CharactersRouter
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModel
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModelMapper

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val charactersRouter: CharactersRouter
) : BaseViewModel() {

    val characters = MutableLiveData<List<CharacterModel>>()

    fun getCharacters(offset: Int = 0) {
        getCharactersUseCase.execute(
            params = GetCharactersUseCase.Params(offset),
            error = ::handleError,
            response = ::handleCharactersResponse
        )
    }

    fun onCharacterClick(id: Int) {
        charactersRouter.onCharacterClick(id)
    }

    private fun handleCharactersResponse(charactersList: List<Character>) {
        characters.postValue(CharacterModelMapper.map(charactersList))
    }

    override fun destroy() {
        charactersRouter.unAttach()
    }
}