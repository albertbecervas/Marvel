package com.abecerra.marvel_data.db.dao

import com.abecerra.marvel_data.db.entity.CharacterEntity
import io.realm.Case
import io.realm.Realm
import io.realm.RealmList

class CharactersDaoImpl : CharactersDao {
    override suspend fun saveCharacters(characters: List<CharacterEntity>) {
        Realm.getDefaultInstance().executeTransactionAsync {
            val list = RealmList<CharacterEntity>()
            list.addAll(characters)
            it.insertOrUpdate(list)
        }
    }

    override suspend fun getCharacters(offset: Int): List<CharacterEntity> {
        return Realm.getDefaultInstance().where(CharacterEntity::class.java)
            .equalTo(OFFSET, offset).findAll().toList<CharacterEntity>()
    }

    override suspend fun searchCharacters(name: String): List<CharacterEntity> {
        val characters = Realm.getDefaultInstance().where(CharacterEntity::class.java)
            .beginsWith(NAME, name, Case.INSENSITIVE).findAll().toList<CharacterEntity>()
        return characters
    }

    companion object {
        private const val OFFSET = "offset"
        private const val NAME = "name"
    }
}