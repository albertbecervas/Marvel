package com.abecerra.marvel.di.domain

import com.abecerra.marvel_domain.usecase.GetCharacterDetailSectionsUseCase
import com.abecerra.marvel_domain.usecase.GetCharactersUseCase
import com.abecerra.marvel_domain.usecase.SearchCharactersUseCase
import org.koin.dsl.module

object UseCaseModule {

    fun get() = module {
        single { GetCharactersUseCase(get()) }
        single { GetCharacterDetailSectionsUseCase(get()) }
        single { SearchCharactersUseCase(get()) }
    }

}