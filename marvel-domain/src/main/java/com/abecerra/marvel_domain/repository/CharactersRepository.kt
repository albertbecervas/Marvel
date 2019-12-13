package com.abecerra.marvel_domain.repository

import com.abecerra.marvel_domain.model.Character

interface CharactersRepository {

    suspend fun getCharacters(offset: Int): List<Character>

}