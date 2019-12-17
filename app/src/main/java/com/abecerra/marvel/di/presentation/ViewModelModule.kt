package com.abecerra.marvel.di.presentation

import android.content.Context
import com.abecerra.marvel_presentation.ui.characterdetail.viewmodel.CharacterDetailViewModel
import com.abecerra.marvel_presentation.ui.characters.viewmodel.CharactersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

object ViewModelModule {

    fun get() = module {
        viewModel { (ctx: Context) -> CharactersViewModel(get(), get { parametersOf(ctx) }) }
        viewModel { (ctx: Context) -> CharacterDetailViewModel(get(), get { parametersOf(ctx) }) }
    }
}