package com.abecerra.marvel.navigation.navigator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abecerra.marvel.R

object Navigator {

    fun Context.replaceFragment(fragment: Fragment) {
        (this as? AppCompatActivity)?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fl, fragment)
            ?.addToBackStack(fragment.tag)
            ?.commit()
    }
}