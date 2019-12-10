package com.abecerra.marvel.di

import com.abecerra.marvel_data.repository.CharactersRepositoryImpl
import com.abecerra.marvel_domain.repository.CharactersRepository
import org.koin.dsl.module

object RepositoryModule {

    fun get() = module {
        single<CharactersRepository> { CharactersRepositoryImpl(get()) }
    }

}