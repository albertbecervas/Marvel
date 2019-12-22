package com.abecerra.marvel_data.db.entity.mapper

import com.abecerra.marvel_data.db.entity.CharacterEntity
import com.abecerra.marvel_domain.model.Character

object CharacterEntityMapper {

    fun map(from: List<CharacterEntity>): List<Character> {
        return from.map { it.mapToCharacter() }
    }

    private fun CharacterEntity.mapToCharacter(): Character {
        return Character(id, name, description, thumbnail)
    }
}