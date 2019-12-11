package com.abecerra.marvel

import androidx.multidex.MultiDexApplication
import com.abecerra.marvel.di.AppModule
import org.koin.core.context.startKoin

class MarvelApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initDi()
    }

    private fun initDi() {
        startKoin {
            modules(AppModule.get())
        }
    }
}