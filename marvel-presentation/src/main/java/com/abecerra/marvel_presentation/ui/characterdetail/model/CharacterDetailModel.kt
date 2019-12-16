package com.abecerra.marvel_presentation.ui.characterdetail.model

import com.abecerra.marvel_domain.model.CharacterSection

data class CharacterDetailModel(
    val name: String,
    val description: String,
    val image: String,
    val sections: List<CharacterSection>
)
