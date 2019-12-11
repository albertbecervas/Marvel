package com.abecerra.marvel_domain.usecase

import com.abecerra.marvel_domain.repository.CharactersRepository

class GetCharactersUseCase(private val charactersRepository: CharactersRepository) {

    fun execute(){
        //charactersRepository.getCharacters()
    }

}