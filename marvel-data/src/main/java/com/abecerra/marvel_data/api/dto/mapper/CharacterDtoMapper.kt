package com.abecerra.marvel_data.api.dto.mapper

import com.abecerra.marvel_data.api.dto.CharacterDto
import com.abecerra.marvel_data.db.entity.CharacterEntity
import com.abecerra.marvel_domain.model.Character

object CharacterDtoMapper {

    fun map(from: List<CharacterDto>): List<Character> {
        return from.map { it.mapToCharacter() }
    }

    private fun CharacterDto.mapToCharacter(): Character {
        return Character(id, name, description, ThumbnailMapper.map(thumbnail))
    }

    fun mapToCharacterEntity(from: List<CharacterDto>, offset: Int): List<CharacterEntity> {
        return from.map { it.mapToCharacterEntity(offset) }
    }

    private fun CharacterDto.mapToCharacterEntity(offset: Int): CharacterEntity {
        return CharacterEntity(
            id, offset, name, description, ThumbnailMapper.map(thumbnail)
        )
    }
}