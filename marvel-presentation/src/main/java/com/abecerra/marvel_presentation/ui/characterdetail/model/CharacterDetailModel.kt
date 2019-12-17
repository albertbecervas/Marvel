package com.abecerra.marvel_presentation.ui.characterdetail.model

import com.abecerra.marvel_domain.model.CharacterSection
import java.io.Serializable

data class CharacterDetailModel(
    val name: String,
    val description: String,
    val image: String,
    var sections: List<CharacterSection> = arrayListOf()
) : Serializable
