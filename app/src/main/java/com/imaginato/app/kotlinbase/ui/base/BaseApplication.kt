package com.imaginato.app.kotlinbase.ui.base

import android.app.Application

/**
 * Created by xukai on 2018/10/13.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeComponents()
    }

    private fun initializeComponents() {

    }
}