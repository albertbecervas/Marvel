package com.abecerra.marvel_presentation.navigation.routers

import android.content.Context
import com.abecerra.marvel_presentation.navigation.navigator.Navigator.replaceFragment
import com.abecerra.marvel_presentation.ui.characterdetail.model.CharacterDetailModel
import com.abecerra.marvel_presentation.ui.characterdetail.view.CharacterDetailFragment
import com.abecerra.marvel_presentation.ui.characters.CharactersRouter
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModel

class CharactersRouterImpl(private var context: Context?) : CharactersRouter {
    override fun onCharacterClick(characterModel: CharacterModel) {
        context?.replaceFragment(
            CharacterDetailFragment.newInstance(prepareCharacterDetailData(characterModel))
        )
    }

    private fun prepareCharacterDetailData(characterModel: CharacterModel): CharacterDetailModel {
        return with(characterModel) {
            CharacterDetailModel(name, description, thumbnail)
        }
    }

    override fun unAttach() {
        this.context = null
    }
}