package com.abecerra.marvel_domain.usecase

import com.abecerra.marvel_domain.model.CharacterSection
import com.abecerra.marvel_domain.repository.CharactersRepository
import com.abecerra.marvel_domain.usecase.GetCharacterDetailSectionsUseCase.CharacterDetailParams
import com.abecerra.marvel_domain.usecase.base.BaseUseCase

class GetCharacterDetailSectionsUseCase(private val charactersRepository: CharactersRepository) :
    BaseUseCase<ArrayList<CharacterSection>, CharacterDetailParams>() {

    override suspend fun executeOnBackground(params: CharacterDetailParams): ArrayList<CharacterSection> {
        return charactersRepository.getCharacterDetailSections()
    }

    class CharacterDetailParams
}