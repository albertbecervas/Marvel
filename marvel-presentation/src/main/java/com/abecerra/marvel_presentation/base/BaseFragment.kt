package com.abecerra.marvel_presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.abecerra.marvel_domain.model.general.Failure
import com.abecerra.marvel_presentation.utils.observe
import kotlinx.android.synthetic.main.fragment_characters.*

abstract class BaseFragment : Fragment() {

    private var viewModel: BaseViewModel? = null

    abstract fun getLayout(): Int

    abstract fun getViewModel(): BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
        viewModel?.let {
            observe(it.error, ::showError)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(getLayout(), container, false)

    private fun showError(failure: Failure?) {
        Toast.makeText(this.context, "error", Toast.LENGTH_LONG).show()
    }

    protected fun showLoading() {
        progress_bar?.visibility = View.VISIBLE
    }

    protected fun hideLoading() {
        progress_bar?.visibility = View.GONE
    }

    override fun onDestroy() {
        viewModel?.destroy()
        super.onDestroy()
    }
}