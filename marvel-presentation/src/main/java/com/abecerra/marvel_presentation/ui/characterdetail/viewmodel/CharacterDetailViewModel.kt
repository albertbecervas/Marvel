package com.abecerra.marvel_presentation.ui.characterdetail.viewmodel

import androidx.lifecycle.MutableLiveData
import com.abecerra.marvel_domain.model.CharacterDetail
import com.abecerra.marvel_domain.usecase.GetCharacterDetailUseCase
import com.abecerra.marvel_presentation.base.BaseViewModel
import com.abecerra.marvel_presentation.ui.characterdetail.CharactersDetailRouter
import com.abecerra.marvel_presentation.ui.characterdetail.model.CharacterDetailModel
import com.abecerra.marvel_presentation.ui.characterdetail.model.CharacterDetailModelMapper

class CharacterDetailViewModel(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    private val charactersDetailRouter: CharactersDetailRouter
) : BaseViewModel() {

    val characterDetail = MutableLiveData<CharacterDetailModel>()

    fun getCharacterDetail(id: Int) {
        getCharacterDetailUseCase.execute(
            params = GetCharacterDetailUseCase.CharacterDetailParams(id),
            error = ::handleError,
            response = ::handleCharacterDetailResponse
        )
    }

    private fun handleCharacterDetailResponse(characterDetail: CharacterDetail) {
        this.characterDetail.postValue(CharacterDetailModelMapper.map(characterDetail))
    }

    override fun destroy() {
        charactersDetailRouter.unAttach()
    }
}