package com.abecerra.marvel_presentation.ui.characterdetail.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abecerra.marvel_domain.model.CharacterSection
import kotlinx.android.synthetic.main.item_character_section.view.*

class CharacterSectionsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(characterSection: CharacterSection) {
        view.tv_section_name?.text = characterSection.name
    }
}