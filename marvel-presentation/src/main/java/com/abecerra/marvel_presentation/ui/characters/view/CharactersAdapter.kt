package com.abecerra.marvel_presentation.ui.characters.view

import android.view.ViewGroup
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.base.BaseAdapter
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModel
import com.abecerra.marvel_presentation.utils.inflate

class CharactersAdapter : BaseAdapter<CharactersViewHolder, CharacterModel>() {

    override fun onBindViewHolder(holder: CharactersViewHolder, item: CharacterModel, pos: Int) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder =
        CharactersViewHolder(inflate(parent, R.layout.item_characters_list))
}