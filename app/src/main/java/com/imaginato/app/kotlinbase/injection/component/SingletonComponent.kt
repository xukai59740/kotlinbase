package com.imaginato.app.kotlinbase.injection.component

import com.imaginato.app.kotlinbase.data.repository.AccountRepository
import com.imaginato.app.kotlinbase.injection.ActivityScope
import com.imaginato.app.kotlinbase.injection.module.NetModule
import com.imaginato.app.kotlinbase.ui.base.BaseApplication
import dagger.Component
import javax.inject.Singleton

/**
 * Created by xukai on 2018/10/13.
 */

@Component(modules = arrayOf(NetModule::class))
@Singleton
interface SingletonComponent {

    fun provideAccountRepository():AccountRepository

    object Initializer {
        fun init(): SingletonComponent {
            return DaggerSingletonComponent.create()
        }
    }
}