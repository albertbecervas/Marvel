package com.abecerra.marvel.di

object AppModule {

    fun get() = listOf(
        ViewModelModule.get(),
        UseCaseModule.get(),
        RepositoryModule.get(),
        ServiceModule.get()
    )

}