package com.abecerra.marvel.di.presentation

import android.content.Context
import com.abecerra.comics.ComicsViewModel
import com.abecerra.marvel_presentation.base.BaseViewModel
import com.abecerra.marvel_presentation.ui.characters.viewmodel.CharactersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

object ViewModelModule {

    fun get() = module {
        viewModel<BaseViewModel> { (ctx: Context) ->
            CharactersViewModel(get(), get { parametersOf(ctx) })
        }
        viewModel { (ctx: Context) -> ComicsViewModel(get { parametersOf(ctx) }) }
    }
}