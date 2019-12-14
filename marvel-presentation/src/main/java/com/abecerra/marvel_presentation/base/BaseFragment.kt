package com.abecerra.marvel_presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.abecerra.marvel_domain.model.base.Failure
import com.abecerra.marvel_presentation.utils.observe
import kotlinx.android.synthetic.main.fragment_characters.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    private val _viewModel: BaseViewModel by viewModel { parametersOf(this.context) }
    protected val viewModel: VM
        get() {
            return _viewModel as VM
        }

    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe(viewModel.error, ::showError)
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
        viewModel.destroy()
        super.onDestroy()
    }
}