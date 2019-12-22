package com.abecerra.marvel_domain.repository

import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.model.CharacterSection

interface CharactersRepository {

    suspend fun getCharacters(offset: Int): List<Character>

    suspend fun getCharactersStartingWith(name: String): List<Character>

    suspend fun getCharacterDetailSections(): ArrayList<CharacterSection>
}