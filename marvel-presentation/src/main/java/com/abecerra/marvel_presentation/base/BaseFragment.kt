package com.abecerra.marvel_presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.abecerra.marvel_domain.model.base.Failure
import com.abecerra.marvel_presentation.R
import com.abecerra.marvel_presentation.utils.observe

abstract class BaseFragment : Fragment() {

    abstract fun getLayout(): Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(getLayout(), container, false)

    protected fun showError(failure: Failure?) {
        Toast.makeText(this.context, "error", Toast.LENGTH_LONG).show()
    }
}