package com.abecerra.marvel.di.presentation

import android.content.Context
import com.abecerra.comics.ComicsRouter
import com.abecerra.marvel.navigation.routers.CharactersRouterImpl
import com.abecerra.marvel.navigation.routers.ComicsRouterImpl
import com.abecerra.marvel_presentation.ui.characters.CharactersRouter
import org.koin.dsl.module

object NavigationModule {

    fun get() = module {
        single<CharactersRouter> { (ctx: Context) -> CharactersRouterImpl(ctx) }
        single<ComicsRouter> { (ctx: Context) -> ComicsRouterImpl(ctx) }
    }
}