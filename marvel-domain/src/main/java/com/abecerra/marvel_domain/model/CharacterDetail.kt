package com.abecerra.marvel_domain.model

data class CharacterDetail(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val sections: List<CharacterSection>
)