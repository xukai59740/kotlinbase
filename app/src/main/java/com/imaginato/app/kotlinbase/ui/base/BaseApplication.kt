package com.imaginato.app.kotlinbase.ui.base

import android.app.Application
import com.imaginato.app.kotlinbase.injection.ApplicationComponent

/**
 * Created by xukai on 2018/10/13.
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeComponents()
    }

    private lateinit var mApplicationComponent: ApplicationComponent
    private fun initializeComponents() {
//        mApplicationComponent = DaggerApplicationComponent
//                .Initializer.init(this)
    }
}