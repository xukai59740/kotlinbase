package com.imaginato.app.kotlinbase.injection.component

import com.imaginato.app.kotlinbase.injection.ActivityScope
import com.imaginato.app.kotlinbase.injection.module.PresenterModule
import com.imaginato.app.kotlinbase.ui.home.HomeActivity
import com.imaginato.app.kotlinbase.ui.login.LoginActivity
import dagger.Component

/**
 * Created by xukai on 2018/10/13.
 */

@ActivityScope
@Component(modules = arrayOf(PresenterModule::class), dependencies = arrayOf(SingletonComponent::class))
interface PresenterComponent {
    fun inject(activity: HomeActivity)
    fun inject(activity: LoginActivity)
}