package com.abecerra.marvel_domain.usecase

import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.repository.CharactersRepository
import com.abecerra.marvel_domain.usecase.base.BaseUseCase

class GetCharactersUseCase(private val charactersRepository: CharactersRepository) :
    BaseUseCase<List<Character>, GetCharactersUseCase.Params>() {

    override suspend fun executeOnBackground(params: Params): List<Character> {
        return charactersRepository.getCharacters(params.offset)
    }

    data class Params(val offset: Int)
}

// Notes: One thing that I do not like about this execution is that you can not know who is calling.