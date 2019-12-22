package com.abecerra.marvel_data.repository

import com.abecerra.marvel_data.api.dto.mapper.CharacterDtoMapper
import com.abecerra.marvel_data.api.dto.mapper.CharacterDtoMapper.mapToCharacterEntity
import com.abecerra.marvel_data.api.services.CharactersService
import com.abecerra.marvel_data.db.dao.CharactersDao
import com.abecerra.marvel_data.db.entity.mapper.CharacterEntityMapper
import com.abecerra.marvel_data.utils.isInternetAvailable
import com.abecerra.marvel_domain.model.Character
import com.abecerra.marvel_domain.model.CharacterSection
import com.abecerra.marvel_domain.repository.CharactersRepository

class CharactersRepositoryImpl(
    private val charactersService: CharactersService,
    private val charactersDao: CharactersDao
) : CharactersRepository {

    override suspend fun getCharacters(offset: Int): List<Character> {
        return if (isInternetAvailable()){
            val characters = charactersService.getCharactersAsync(offset).await()
            charactersDao.saveCharacters(mapToCharacterEntity(characters.data.results, offset))
            CharacterDtoMapper.map(characters.data.results)
        } else {
            val characters = charactersDao.getCharacters(offset)
            CharacterEntityMapper.map(characters)
        }
    }

    override suspend fun getCharactersStartingWith(name: String): List<Character> {
        return emptyList()
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