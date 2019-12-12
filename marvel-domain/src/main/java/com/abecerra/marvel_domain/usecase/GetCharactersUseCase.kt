package com.abecerra.marvel_domain.usecase

import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.repository.CharactersRepository
import com.abecerra.marvel_domain.usecase.base.BaseUseCase

class GetCharactersUseCase(private val charactersRepository: CharactersRepository) :
    BaseUseCase<List<Character>>() {

    override suspend fun executeOnBackground(): List<Character> {
        return charactersRepository.getCharacters()
    }

}