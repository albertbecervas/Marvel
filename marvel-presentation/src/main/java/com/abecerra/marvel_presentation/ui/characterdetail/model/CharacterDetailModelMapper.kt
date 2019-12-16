package com.abecerra.marvel_presentation.ui.characterdetail.model

import com.abecerra.marvel_domain.model.CharacterDetail

object CharacterDetailModelMapper {

    fun map(from: CharacterDetail): CharacterDetailModel {
        return with(from) {
            CharacterDetailModel(name, description, image, sections)
        }
    }

}