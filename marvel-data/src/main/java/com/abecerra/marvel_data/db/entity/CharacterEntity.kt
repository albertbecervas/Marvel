package com.abecerra.marvel_data.db.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CharacterEntity(
    @PrimaryKey
    var id: Int = -1,
    var offset: Int = 0,
    var name: String = "",
    var description: String = "",
    var thumbnail: String = ""
) : RealmObject()