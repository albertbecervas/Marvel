package com.abecerra.marvel_presentation.ui.characters.viewmodel

import androidx.lifecycle.MutableLiveData
import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.usecase.GetCharactersUseCase
import com.abecerra.marvel_domain.usecase.SearchCharactersUseCase
import com.abecerra.marvel_presentation.base.BaseViewModel
import com.abecerra.marvel_presentation.ui.characters.CharactersRouter
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModel
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModelMapper

class CharactersViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val searchCharactersUseCase: SearchCharactersUseCase,
    private val charactersRouter: CharactersRouter
) : BaseViewModel() {

    val characters = MutableLiveData<List<CharacterModel>>()

    val searchedCharacters = MutableLiveData<List<CharacterModel>>()

    fun getCharacters(offset: Int = 0) {
        getCharactersUseCase.execute(
            params = GetCharactersUseCase.Params(offset),
            error = ::handleError,
            response = ::handleCharactersResponse
        )
    }

    fun searchCharactersByName(nameStartWith: String) {
        searchCharactersUseCase.execute(
            params = SearchCharactersUseCase.SearchCharactersParams(nameStartWith),
            error = ::handleError,
            response = ::handleSearchResponse
        )
    }

    fun onCharacterClick(character: CharacterModel) {
        this.charactersRouter.onCharacterClick(character)
    }

    private fun handleCharactersResponse(charactersList: List<Character>) {
        this.characters.postValue(CharacterModelMapper.map(charactersList))
    }

    private fun handleSearchResponse(characters: List<Character>) {
        this.searchedCharacters.postValue(CharacterModelMapper.map(characters))
    }

    override fun destroy() {
        this.charactersRouter.unAttach()
    }
}