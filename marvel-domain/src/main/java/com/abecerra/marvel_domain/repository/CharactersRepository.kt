package com.abecerra.marvel_domain.repository

import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.model.CharacterDetail

interface CharactersRepository {

    suspend fun getCharacters(offset: Int): List<Character>

    suspend fun getCharacterDetail(id: Int): CharacterDetail
}