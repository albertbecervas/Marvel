package com.abecerra.comics

import androidx.lifecycle.ViewModel

class ComicsViewModel(private val comicsRouter: ComicsRouter) : ViewModel() {

    fun nav() {
        comicsRouter.nav()
    }

}