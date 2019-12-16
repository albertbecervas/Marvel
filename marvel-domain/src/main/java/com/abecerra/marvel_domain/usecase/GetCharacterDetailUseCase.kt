package com.abecerra.marvel_domain.usecase

import com.abecerra.marvel_domain.model.CharacterDetail
import com.abecerra.marvel_domain.repository.CharactersRepository
import com.abecerra.marvel_domain.usecase.GetCharacterDetailUseCase.CharacterDetailParams
import com.abecerra.marvel_domain.usecase.base.BaseUseCase

class GetCharacterDetailUseCase(private val charactersRepository: CharactersRepository) :
    BaseUseCase<CharacterDetail, CharacterDetailParams>() {

    override suspend fun executeOnBackground(params: CharacterDetailParams): CharacterDetail {
        return charactersRepository.getCharacterDetail(params.id)
    }

    data class CharacterDetailParams(
        val id: Int
    )
}