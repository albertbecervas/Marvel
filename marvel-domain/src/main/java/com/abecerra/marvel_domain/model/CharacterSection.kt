package com.abecerra.marvel_domain.model

data class CharacterSection(
    val sectionName: String,
    val items: List<Section>
)

data class Section(
    val name: String,
    val resourceUri: String
)


