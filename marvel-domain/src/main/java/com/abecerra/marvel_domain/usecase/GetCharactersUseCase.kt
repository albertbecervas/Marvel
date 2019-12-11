package com.abecerra.marvel_domain.usecase

import com.abecerra.marvel_domain.base.UseCase
import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.repository.CharactersRepository

class GetCharactersUseCase(private val charactersRepository: CharactersRepository) :
    UseCase<List<Character>>() {


    override suspend fun executeOnBackground(): List<Character> {
        return charactersRepository.getCharacters()
    }

}