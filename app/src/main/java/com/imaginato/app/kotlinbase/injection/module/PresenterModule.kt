package com.imaginato.app.kotlinbase.injection.module

import com.imaginato.app.kotlinbase.injection.ActivityScope
import com.imaginato.app.kotlinbase.ui.home.presenter.HomeContract
import com.imaginato.app.kotlinbase.ui.home.presenter.HomePresenterImpl
import com.imaginato.app.kotlinbase.ui.home.presenter.LoginContract
import com.imaginato.app.kotlinbase.ui.home.presenter.LoginPresenterImpl
import com.imaginato.app.kotlinbase.usecase.LoginUseCase
import com.imaginato.app.kotlinbase.usecase.ReadLoginUseCase
import dagger.Module
import dagger.Provides

/**
 * Created by xukai on 2018/10/13.
 */
@Module
class PresenterModule {

    @Provides
    @ActivityScope
    fun provideHomePresenterImpl(loginUseCase: LoginUseCase, readLoginUseCase: ReadLoginUseCase): HomeContract.Presenter {
        return HomePresenterImpl(loginUseCase, readLoginUseCase)
    }

    @Provides
    @ActivityScope
    fun provideLoginPresenterImpl(): LoginContract.Presenter {
        return LoginPresenterImpl()
    }
}