package com.abecerra.marvel_presentation.ui.characterdetail.view


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.base.BaseFragment
import com.abecerra.marvel_presentation.base.BaseViewModel
import com.abecerra.marvel_presentation.ui.characterdetail.model.CharacterDetailModel
import com.abecerra.marvel_presentation.ui.characterdetail.viewmodel.CharacterDetailViewModel
import com.abecerra.marvel_presentation.utils.observe
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_character_detail.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharacterDetailFragment private constructor() : BaseFragment() {

    private val viewModel: CharacterDetailViewModel by viewModel { parametersOf(this.context) }

    private var characterId: Int? = null

    private var adapter: CharacterSectionsAdapter? = null

    override fun getLayout(): Int = R.layout.fragment_character_detail

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArguments()
        observe(viewModel.characterDetail, ::updateCharacterDetail)
    }

    private fun parseArguments() {
        arguments?.let { characterId = it.get(CHARACTER_ID) as? Int }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterId?.let { viewModel.getCharacterDetail(it) }

        setViews(view)
    }

    private fun setViews(view: View) {
        adapter = CharacterSectionsAdapter()
        rv_sections.layoutManager = LinearLayoutManager(view.context)
        rv_sections.adapter = adapter
    }

    private fun updateCharacterDetail(characterDetailModel: CharacterDetailModel?) {
        characterDetailModel?.let {
            tv_name.text = it.name
            tv_description.text = it.description
            Glide.with(this).load(characterDetailModel.image).into(iv_character)
            adapter?.setItems(it.sections)
        }
    }

    companion object {

        private const val CHARACTER_ID: String = "Character_id"

        fun newInstance(id: Int): CharacterDetailFragment {
            val characterDetailFragment = CharacterDetailFragment()

            val bundle = Bundle().apply {
                putInt(CHARACTER_ID, id)
            }

            characterDetailFragment.arguments = bundle
            return characterDetailFragment
        }
    }
}
