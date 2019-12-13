package com.abecerra.marvel_data.di

import com.abecerra.marvel_data.api.services.CharactersService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceModule {

    private const val BASE_URL = "http://gateway.marvel.com"

    private var retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun provideCharactersService(): CharactersService {
        return retrofit.create(CharactersService::class.java)
    }

}