package com.abecerra.marvel_presentation.base

import androidx.lifecycle.ViewModel
import com.abecerra.marvel_domain.model.base.Failure

abstract class BaseViewModel : ViewModel() {

    protected fun handleError(failure: Failure) {

    }
}