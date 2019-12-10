package com.abecerra.marvel

import android.app.Application
import com.abecerra.marvel.di.AppModule
import org.koin.core.context.startKoin

class MarvelApplication : Application() {

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