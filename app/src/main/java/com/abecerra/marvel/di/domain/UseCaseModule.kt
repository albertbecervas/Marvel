package com.abecerra.marvel.di.domain

import com.abecerra.marvel_domain.usecase.GetCharacterDetailUseCase
import com.abecerra.marvel_domain.usecase.GetCharactersUseCase
import org.koin.dsl.module

object UseCaseModule {

    fun get() = module {
        single { GetCharactersUseCase(get()) }
        single { GetCharacterDetailUseCase(get()) }
    }

}