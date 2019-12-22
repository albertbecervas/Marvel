package com.abecerra.marvel_presentation.ui.components

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.abecerra.marvel_presentation.R
import kotlinx.android.synthetic.main.view_search.view.*


class SearchComponent : LinearLayout, SearchComponentInput {

    constructor(context: Context?) : super(context) {
        init(context)
    }

    constructor(context: Context?, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context?, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context?) {
        val view = inflate(context, R.layout.view_search, null)
        addView(view)

        tv_cancel?.setOnClickListener { hideSearch() }
    }

    fun showSearch() {
        layout?.visibility = View.VISIBLE
    }

    fun hideSearch() {
        layout?.visibility = View.GONE
    }

    override fun setOutput(listener: SearchComponentOutput) {

    }
}

interface SearchComponentInput {
    fun setOutput(listener: SearchComponentOutput)
}

interface SearchComponentOutput {
    fun onSearch(text: String)
}