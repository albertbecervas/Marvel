package com.abecerra.marvel_data.db.dao

import com.abecerra.marvel_data.db.entity.CharacterEntity

interface CharactersDao {

    suspend fun saveCharacters(characters: List<CharacterEntity>)

    suspend fun getCharacters(offset: Int): List<CharacterEntity>

    suspend fun searchCharacters(name: String): List<CharacterEntity>

}