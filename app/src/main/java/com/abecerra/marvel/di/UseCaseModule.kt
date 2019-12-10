package com.abecerra.marvel.di

import com.abecerra.marvel_domain.usecase.GetCharactersUseCase
import org.koin.dsl.module

object UseCaseModule {

    fun get() = module {
        single { GetCharactersUseCase(get()) }
    }

}