package com.abecerra.marvel_presentation.ui.characters.view


import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.base.BaseFragment
import com.abecerra.marvel_presentation.ui.characters.model.CharacterModel
import com.abecerra.marvel_presentation.ui.characters.viewmodel.CharactersViewModel
import com.abecerra.marvel_presentation.utils.RecyclerPaginationListener
import com.abecerra.marvel_presentation.utils.observe
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.android.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment() {

    private val viewModel: CharactersViewModel by viewModel()

    private var adapter: CharactersAdapter? = null

    private var pagination: RecyclerPaginationListener? = null

    override fun getLayout(): Int = R.layout.fragment_characters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observe(viewModel.characters, ::updateList)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

        progress_bar.visibility = View.VISIBLE
        viewModel.getCharacters()
    }

    private fun initViews() {
        adapter = CharactersAdapter()
        pagination = RecyclerPaginationListener {
            progress_bar.visibility = View.VISIBLE
            viewModel.getCharacters(it)
        }

        rv_characters.layoutManager = GridLayoutManager(context, SPAN_COUNT)
        rv_characters.adapter = adapter
        pagination?.let { rv_characters.addOnScrollListener(it) }
    }

    private fun updateList(characters: List<CharacterModel>?) {
        progress_bar.visibility = View.GONE
        characters?.let {
            adapter?.addItems(it)
            pagination?.setEndLoading()
        }
    }

    companion object {
        const val SPAN_COUNT = 3
    }
}
