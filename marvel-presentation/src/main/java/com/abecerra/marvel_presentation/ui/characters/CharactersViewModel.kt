package com.abecerra.marvel_presentation.ui.characters

import androidx.lifecycle.ViewModel
import com.abecerra.marvel_domain.usecase.GetCharactersUseCase

class CharactersViewModel(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

    fun test() {
        getCharactersUseCase.execute()
    }
}