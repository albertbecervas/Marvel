package com.abecerra.marvel_presentation.ui.characters.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_characters_list.view.*

class CharactersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(onCharacterSelected: (id: Int) -> Unit, character: CharacterModel) {
        view.tv_name?.text = character.name
        Glide.with(view.context).load(character.thumbnail).into(view.iv_character)
        view.setOnClickListener {
            onCharacterSelected(character.id)
        }
    }
}