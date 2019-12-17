package com.abecerra.marvel_presentation.ui.characterdetail.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.abecerra.marvel_domain.model.CharacterSection
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.base.BaseFragment
import com.abecerra.marvel_presentation.base.BaseViewModel
import com.abecerra.marvel_presentation.base.ToolbarListener
import com.abecerra.marvel_presentation.ui.characterdetail.model.CharacterDetailModel
import com.abecerra.marvel_presentation.ui.characterdetail.viewmodel.CharacterDetailViewModel
import com.abecerra.marvel_presentation.utils.observe
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_character_detail.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharacterDetailFragment private constructor() : BaseFragment() {

    private val viewModel: CharacterDetailViewModel by viewModel { parametersOf(this.context) }

    private var character: CharacterDetailModel? = null

    private var adapter: CharacterSectionsAdapter? = null

    private var mToolbarListener: ToolbarListener? = null

    override fun getLayout(): Int = R.layout.fragment_character_detail

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe(viewModel.characterDetailSections, ::updateCharacterDetailSections)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parseArguments()
        prepareToolbar()
    }

    private fun parseArguments() {
        arguments?.let { character = it.get(CHARACTER) as? CharacterDetailModel }
    }

    private fun prepareToolbar() {
        setHasOptionsMenu(false)
        mToolbarListener = context as? ToolbarListener
        mToolbarListener?.showDetailToolbar(character?.name)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews(view)

        character?.let { setCharacterDetail(it) }
        getCharacterDetailSections()
    }

    private fun setViews(view: View) {
        adapter = CharacterSectionsAdapter()
        rv_sections.layoutManager = LinearLayoutManager(view.context)
        rv_sections.adapter = adapter
    }

    private fun setCharacterDetail(characterDetailModel: CharacterDetailModel) {
        with(characterDetailModel) {
            tv_description.text = description
            Glide.with(this@CharacterDetailFragment).load(characterDetailModel.image)
                .into(iv_character)
        }
    }

    private fun getCharacterDetailSections() {
        viewModel.getCharacterDetailSections()
    }

    private fun updateCharacterDetailSections(characterSections: ArrayList<CharacterSection>?) {
        characterSections?.let {
            character?.sections = it
            adapter?.setItems(it)
        }
    }

    companion object {
        private const val CHARACTER: String = "character"

        fun newInstance(character: CharacterDetailModel): CharacterDetailFragment {
            val characterDetailFragment = CharacterDetailFragment()

            val bundle = Bundle().apply {
                putSerializable(CHARACTER, character)
            }

            characterDetailFragment.arguments = bundle
            return characterDetailFragment
        }
    }
}
