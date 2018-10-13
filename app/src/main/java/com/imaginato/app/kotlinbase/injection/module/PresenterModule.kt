package com.imaginato.app.kotlinbase.injection.module

import com.imaginato.app.kotlinbase.injection.ActivityScope
import com.imaginato.app.kotlinbase.ui.home.HomeContract
import com.imaginato.app.kotlinbase.ui.home.HomePresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by xukai on 2018/10/13.
 */
@Module
class PresenterModule {

    @Provides
    @ActivityScope
    fun provideHomePresenterImpl():HomeContract.Presenter{
        return HomePresenterImpl()
    }

}