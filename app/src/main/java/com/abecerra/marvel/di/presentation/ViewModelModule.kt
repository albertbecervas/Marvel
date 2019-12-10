package com.abecerra.marvel.di.presentation

import com.abecerra.marvel_presentation.ui.characters.CharactersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {

    fun get() = module {
        viewModel { CharactersViewModel(get()) }
    }
}