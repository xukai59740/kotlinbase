package com.imaginato.app.kotlinbase.ui.home.presenter

import com.imaginato.app.kotlinbase.data.repository.AccountRepository
import com.imaginato.app.kotlinbase.ui.base.RxPresenter
import javax.inject.Inject

/**
 * Created by xukai on 2018/10/13.
 */
class LoginPresenterImpl : RxPresenter<LoginContract.View>, LoginContract.Presenter {

    var accountRepository: AccountRepository

    @Inject constructor(accountRepository: AccountRepository) {
        this@LoginPresenterImpl.accountRepository = accountRepository
    }

}