package com.abecerra.marvel_presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abecerra.marvel_domain.model.general.Failure

abstract class BaseViewModel : ViewModel() {

    val error = MutableLiveData<Failure>()

    protected fun handleError(failure: Failure) {
        error.postValue(failure)
    }

    abstract fun destroy()
}