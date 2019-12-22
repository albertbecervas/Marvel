package com.abecerra.marvel_data.di

import com.abecerra.marvel_data.db.dao.CharactersDao
import com.abecerra.marvel_data.db.dao.CharactersDaoImpl

object DaoModule {

    fun provideCharactersDao(): CharactersDao {
        return CharactersDaoImpl()
    }

}