package com.abecerra.marvel.di

import com.abecerra.marvel.di.data.RepositoryModule
import com.abecerra.marvel.di.domain.UseCaseModule
import com.abecerra.marvel.di.presentation.ViewModelModule

object AppModule {

    fun get() = listOf(
        ViewModelModule.get(),
        UseCaseModule.get(),
        RepositoryModule.get()
    )

}