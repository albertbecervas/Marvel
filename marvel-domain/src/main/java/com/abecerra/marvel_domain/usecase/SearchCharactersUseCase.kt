package com.abecerra.marvel_domain.usecase

import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.repository.CharactersRepository
import com.abecerra.marvel_domain.usecase.base.BaseUseCase

class SearchCharactersUseCase(private val charactersRepository: CharactersRepository) :
    BaseUseCase<List<Character>, SearchCharactersUseCase.SearchCharactersParams>() {

    override suspend fun executeOnBackground(params: SearchCharactersParams): List<Character> {
        return charactersRepository.getCharactersStartingWith(params.nameStartsWith)
    }

    data class SearchCharactersParams(
        val nameStartsWith: String
    )
}