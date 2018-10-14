package com.imaginato.app.kotlinbase.injection.component

import com.imaginato.app.kotlinbase.injection.ActivityScope
import com.imaginato.app.kotlinbase.injection.module.PresenterModule
import com.imaginato.app.kotlinbase.ui.home.HomeActivity
import dagger.Component

/**
 * Created by xukai on 2018/10/13.
 */

@ActivityScope
@Component(modules = arrayOf(PresenterModule::class))
interface PresenterComponent {
    fun inject(homeActivity: HomeActivity)
}