package com.abecerra.marvel.di.data

import com.abecerra.marvel_data.di.DaoModule
import com.abecerra.marvel_data.di.ServiceModule
import com.abecerra.marvel_data.repository.CharactersRepositoryImpl
import com.abecerra.marvel_domain.repository.CharactersRepository
import org.koin.dsl.module

object RepositoryModule {

    fun get() = module {
        single<CharactersRepository> {
            CharactersRepositoryImpl(
                ServiceModule.provideCharactersService(), DaoModule.provideCharactersDao()
            )
        }
    }

}