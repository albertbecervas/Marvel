package com.abecerra.marvel.di

import com.abecerra.marvel_data.api.services.CharactersService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceModule {

    private const val BASE_URL = "http://test.com"

    fun get() = module {
        single { provideRetrofit() }
        single { provideCharactersService(get()) }
    }

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun provideCharactersService(retrofit: Retrofit): CharactersService {
        return retrofit.create(CharactersService::class.java)
    }

}