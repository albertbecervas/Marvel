package com.abecerra.marvel_presentation.ui.characters.model

import com.abecerra.marvel_domain.model.Character

object CharacterModelMapper {

    fun map(from: List<Character>): List<CharacterModel> {
        return from.map { mapToCharacterModel(it) }
    }

    private fun mapToCharacterModel(from: Character): CharacterModel {
        return with(from) {
            CharacterModel(id, name, thumbnail)
        }
    }
}