package com.abecerra.marvel_domain.repository

import com.abecerra.marvel_domain.model.Character

interface CharactersRepository {

    fun getCharacters(count: Int = 0): List<Character>

}