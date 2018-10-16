package com.imaginato.app.kotlinbase.injection.module

import com.imaginato.app.kotlinbase.data.repository.AccountRepository
import com.imaginato.app.kotlinbase.injection.ActivityScope
import com.imaginato.app.kotlinbase.ui.home.presenter.HomeContract
import com.imaginato.app.kotlinbase.ui.home.presenter.HomePresenterImpl
import com.imaginato.app.kotlinbase.ui.home.presenter.LoginContract
import com.imaginato.app.kotlinbase.ui.home.presenter.LoginPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by xukai on 2018/10/13.
 */
@Module
class PresenterModule {

    @Provides
    @ActivityScope
    fun provideHomePresenterImpl(accountRepository: AccountRepository): HomeContract.Presenter {
        return HomePresenterImpl(accountRepository)
    }

    @Provides
    @ActivityScope
    fun provideLoginPresenterImpl(accountRepository: AccountRepository): LoginContract.Presenter {
        return LoginPresenterImpl(accountRepository)
    }
}