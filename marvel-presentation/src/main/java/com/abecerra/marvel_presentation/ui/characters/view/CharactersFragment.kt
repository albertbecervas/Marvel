package com.abecerra.marvel_presentation.ui.characters.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.base.BaseFragment
import com.abecerra.marvel_presentation.base.BaseViewModel
import com.abecerra.marvel_presentation.base.SearchComponentOutput
import com.abecerra.marvel_presentation.base.ToolbarListener
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModel
import com.abecerra.marvel_presentation.ui.characters.viewmodel.CharactersViewModel
import com.abecerra.marvel_presentation.utils.RecyclerPaginationListener
import com.abecerra.marvel_presentation.utils.observe
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CharactersFragment : BaseFragment(), SearchComponentOutput {

    private val viewModel: CharactersViewModel by viewModel { parametersOf(this.context) }

    private var adapter: CharactersAdapter? = null
    private var pagination: RecyclerPaginationListener? = null

    private var toolbarListener: ToolbarListener? = null

    override fun getLayout(): Int = R.layout.fragment_characters

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe(viewModel.characters, ::updateCharactersList)
        observe(viewModel.searchedCharacters, ::setFilteredCharacters)
    }

    private fun prepareToolbar() {
        setHasOptionsMenu(true)
        toolbarListener = context as? ToolbarListener
        toolbarListener?.showSearchToolbar()
        toolbarListener?.bindSearchOutput(this)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareToolbar()
        initViews()

        getCharacters()
    }

    private fun initViews() {
        adapter = CharactersAdapter {
            viewModel.onCharacterClick(it)
        }
        pagination = RecyclerPaginationListener {
            progress_bar.visibility = View.VISIBLE
            viewModel.getCharacters(it)
        }

        rv_characters.layoutManager = GridLayoutManager(context, SPAN_COUNT)
        rv_characters.adapter = adapter
        pagination?.let { rv_characters.addOnScrollListener(it) }

        refresh_layout?.setOnRefreshListener {
            getCharacters()
            refresh_layout?.isRefreshing = false
            adapter?.clear()
        }
    }

    private fun getCharacters() {
        showLoading()
        viewModel.getCharacters()
    }

    private fun updateCharactersList(characters: List<CharacterModel>?) {
        hideLoading()
        characters?.let {
            adapter?.addItems(it)
            pagination?.setEndLoading()
        }
    }

    private fun setFilteredCharacters(characters: List<CharacterModel>?) {
        characters?.let {
            adapter?.setItems(it)
        }
    }

    override fun onSearch(text: String) {
        viewModel.searchCharactersByName(text)
    }

    override fun emptySearch() {
        adapter?.clear()
        getCharacters()
    }

    companion object {
        const val SPAN_COUNT = 3
    }
}
