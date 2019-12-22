package com.abecerra.marvel_presentation.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.utils.StringUtils
import kotlinx.android.synthetic.main.view_search.*
import kotlinx.android.synthetic.main.view_toolbar.*

abstract class BaseToolbarActivity : BaseActivity(), ToolbarListener {

    private var searchComponentOutput: SearchComponentOutput? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        setViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        hideSearch()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.app_bar_search -> showSearch()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setViews() {
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_arrow)
        tv_cancel?.setOnClickListener { hideSearch() }
        et_search.addTextChangedListener(onTextChanged = { text, _, _, count ->
            if (text.toString().isNotEmpty()) {
                searchComponentOutput?.onSearch(text.toString())
            } else {
                searchComponentOutput?.emptySearch()
            }
        })
    }

    private fun showSearch() {
        search_layout?.visibility = View.VISIBLE
    }

    private fun hideSearch() {
        search_layout?.visibility = View.GONE
        et_search.setText(StringUtils.EMPTY_STRING)
    }

    override fun bindSearchOutput(searchComponentOutput: SearchComponentOutput) {
        this.searchComponentOutput = searchComponentOutput
    }

    override fun showSearchToolbar() {
        showSearch()
        hideBackButton()
        iv_marvel_title?.visibility = View.VISIBLE
        supportActionBar?.title = StringUtils.EMPTY_STRING
    }

    override fun showDetailToolbar(title: String?) {
        hideSearch()
        showBackButton()
        iv_marvel_title?.visibility = View.GONE
        supportActionBar?.title = title
    }

    private fun showBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun hideBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
}

interface ToolbarListener {
    fun showSearchToolbar()
    fun showDetailToolbar(title: String?)

    fun bindSearchOutput(searchComponentOutput: SearchComponentOutput)
}

interface SearchComponentOutput {
    fun onSearch(text: String)
    fun emptySearch()
}