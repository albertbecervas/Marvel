package com.abecerra.marvel_presentation.navigation.navigator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abecerra.marvel_presentation.R

object Navigator {

    fun Context.replaceFragment(fragment: Fragment) {
        (this as? AppCompatActivity)?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fl, fragment)
            ?.addToBackStack(fragment.tag)
            ?.commit()
    }
}