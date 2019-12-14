package com.abecerra.marvel.navigation.navigator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abecerra.marvel.R

object Navigator {

    fun Context.replaceFragment(fragment: Fragment) {
        when (this) {
            is AppCompatActivity -> this.supportFragmentManager.beginTransaction()
                .replace(R.id.fl, fragment).commitNow()
            is Fragment -> this.childFragmentManager.beginTransaction()
                .add(R.id.fl, fragment).commit()
        }
    }
}