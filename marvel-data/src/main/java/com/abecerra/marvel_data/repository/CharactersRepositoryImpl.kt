package com.abecerra.marvel_data.repository

import com.abecerra.marvel_data.api.dto.mapper.CharacterDtoMapper
import com.abecerra.marvel_data.api.services.CharactersService
import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.repository.CharactersRepository

class CharactersRepositoryImpl(private val charactersService: CharactersService) :
    CharactersRepository {

    override suspend fun getCharacters(offset: Int): List<Character> {
        val characters = charactersService.getCharactersAsync(offset).await()
        return CharacterDtoMapper.map(characters.data.results)
    }
}