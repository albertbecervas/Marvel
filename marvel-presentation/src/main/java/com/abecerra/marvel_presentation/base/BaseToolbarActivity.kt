package com.abecerra.marvel_presentation.base

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.ui.components.SearchComponentOutput
import com.abecerra.marvel_presentation.utils.StringUtils
import kotlinx.android.synthetic.main.view_toolbar.*

abstract class BaseToolbarActivity : BaseActivity(), ToolbarListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        setViews()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        search_component.hideSearch()
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            R.id.app_bar_search -> search_component.showSearch()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setViews() {
        supportActionBar?.setHomeAsUpIndicator(R.drawable.back_arrow)
    }

    override fun showSearchToolbar() {
        search_component.showSearch()
        hideBackButton()
        iv_marvel_title?.visibility = View.VISIBLE
        supportActionBar?.title = StringUtils.EMPTY_STRING
    }

    override fun showDetailToolbar(title: String?) {
        search_component.hideSearch()
        showBackButton()
        iv_marvel_title?.visibility = View.GONE
        supportActionBar?.title = title
    }

    override fun bindSearchOutput(searchComponentOutput: SearchComponentOutput) {
        search_component
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
