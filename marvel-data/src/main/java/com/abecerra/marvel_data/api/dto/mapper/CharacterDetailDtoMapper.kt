package com.abecerra.marvel_data.api.dto.mapper

import com.abecerra.marvel_data.api.dto.CharacterDetailDto
import com.abecerra.marvel_data.api.dto.SectionDto
import com.abecerra.marvel_domain.model.CharacterDetail
import com.abecerra.marvel_domain.model.CharacterSection
import com.abecerra.marvel_domain.model.Section

object CharacterDetailDtoMapper {

    private const val COMICS_SECTION = "comics"
    private const val STORIES_SECTION = "stories"
    private const val EVENTS_SECTION = "events"
    private const val SERIES_SECTION = "series"

    fun map(from: CharacterDetailDto): CharacterDetail {
        return with(from) {
            CharacterDetail(
                id, name, description, ThumbnailMapper.map(thumbnail),
                sections = mapCharacterSections(this)
            )
        }
    }

    private fun mapCharacterSections(from: CharacterDetailDto): List<CharacterSection> {
        return with(from) {
            val sections = arrayListOf<CharacterSection>()
            sections.add(CharacterSection(COMICS_SECTION, mapSections(comics.items)))
            sections.add(CharacterSection(STORIES_SECTION, mapSections(stories.items)))
            sections.add(CharacterSection(EVENTS_SECTION, mapSections(events.items)))
            sections.add(CharacterSection(SERIES_SECTION, mapSections(series.items)))
            sections
        }
    }

    private fun mapSections(from: List<SectionDto>): List<Section> {
        return from.map { mapSection(it) }
    }

    private fun mapSection(from: SectionDto): Section {
        return with(from) {
            Section(name, resourceUri)
        }
    }

}