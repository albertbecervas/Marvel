package com.abecerra.marvel_presentation.ui.characterdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import com.abecerra.marvel_domain.model.CharacterSection
import com.abecerra.marvel_domain.usecase.GetCharacterDetailSectionsUseCase
import com.abecerra.marvel_presentation.base.BaseViewModel
import com.abecerra.marvel_presentation.ui.characterdetail.CharactersDetailRouter

class CharacterDetailViewModel(
    private val getCharacterDetailSectionsUseCase: GetCharacterDetailSectionsUseCase,
    private val charactersDetailRouter: CharactersDetailRouter
) : BaseViewModel() {

    val characterDetailSections = MutableLiveData<ArrayList<CharacterSection>>()

    fun getCharacterDetailSections() {
        getCharacterDetailSectionsUseCase.execute(
            params = GetCharacterDetailSectionsUseCase.CharacterDetailParams(),
            error = ::handleError,
            response = ::handleCharacterDetailSectionsResponse
        )
    }

    private fun handleCharacterDetailSectionsResponse(characterSections: ArrayList<CharacterSection>) {
        this.characterDetailSections.postValue(characterSections)
    }

    override fun destroy() {
        charactersDetailRouter.unAttach()
    }
}