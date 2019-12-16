package com.abecerra.marvel_presentation.ui.characterdetail.view

import android.view.ViewGroup
import com.abecerra.marvel_domain.model.CharacterSection
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.base.BaseAdapter
import com.abecerra.marvel_presentation.utils.inflate

class CharacterSectionsAdapter : BaseAdapter<CharacterSectionsViewHolder, CharacterSection>() {
    override fun onBindViewHolder(
        holder: CharacterSectionsViewHolder, item: CharacterSection, pos: Int
    ) {
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterSectionsViewHolder =
        CharacterSectionsViewHolder(inflate(parent, R.layout.item_character_section))
}