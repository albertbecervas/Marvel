package com.abecerra.marvel_data.repository

import com.abecerra.marvel_data.api.dto.mapper.CharacterDtoMapper
import com.abecerra.marvel_data.api.services.CharactersService
import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.model.CharacterSection
import com.abecerra.marvel_domain.repository.CharactersRepository

class CharactersRepositoryImpl(private val charactersService: CharactersService) :
    CharactersRepository {

    override suspend fun getCharacters(offset: Int): List<Character> {
        val characters = charactersService.getCharactersAsync(offset).await()
        return CharacterDtoMapper.map(characters.data.results)
    }

    override suspend fun getCharacterDetailSections(): ArrayList<CharacterSection> {
        val sections = arrayListOf<CharacterSection>()
        sections.addAll(
            listOf(
                CharacterSection(COMICS_SECTION), CharacterSection(STORIES_SECTION),
                CharacterSection(EVENTS_SECTION), CharacterSection(SERIES_SECTION)
            )
        )
        return sections
    }

    companion object {
        private const val COMICS_SECTION = "comics"
        private const val STORIES_SECTION = "stories"
        private const val EVENTS_SECTION = "events"
        private const val SERIES_SECTION = "series"
    }
}