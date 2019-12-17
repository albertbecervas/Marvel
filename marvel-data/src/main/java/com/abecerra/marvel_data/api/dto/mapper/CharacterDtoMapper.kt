package com.abecerra.marvel_data.api.dto.mapper

import com.abecerra.marvel_data.api.dto.CharacterDto
import com.abecerra.marvel_domain.model.Character

object CharacterDtoMapper {

    fun map(from: List<CharacterDto>): List<Character> {
        return from.map { it.mapToCharacter() }
    }

    private fun CharacterDto.mapToCharacter(): Character {
        return Character(id, name, description, ThumbnailMapper.map(thumbnail))
    }
}