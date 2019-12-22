package com.abecerra.marvel

import androidx.multidex.MultiDexApplication
import com.abecerra.marvel.di.AppModule
import io.realm.Realm
import org.koin.core.context.startKoin

class MarvelApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initDi()
        initRealm()
    }

    private fun initDi() {
        startKoin {
            modules(AppModule.get())
        }
    }

    private fun initRealm() {
        Realm.init(this)
    }
}