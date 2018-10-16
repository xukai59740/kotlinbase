package com.imaginato.app.kotlinbase.ui.home.presenter

import com.imaginato.app.kotlinbase.model.response.User
import com.imaginato.app.kotlinbase.ui.base.RxPresenter
import com.imaginato.app.kotlinbase.usecase.LoginUseCase
import com.imaginato.app.kotlinbase.usecase.ReadLoginUseCase
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject


/**
 * Created by xukai on 2018/10/13.
 */
class HomePresenterImpl : RxPresenter<HomeContract.View>, HomeContract.Presenter {

    var loginUseCase: LoginUseCase
    var readLoginUseCase: ReadLoginUseCase

    @Inject constructor(loginUseCase: LoginUseCase, readLoginUseCase: ReadLoginUseCase) {
        this@HomePresenterImpl.loginUseCase = loginUseCase
        this@HomePresenterImpl.readLoginUseCase = readLoginUseCase
    }

    override fun detachView() {
        loginUseCase.unsubscribe()
        readLoginUseCase.unsubscribe()
        super.detachView()
    }

    override fun loadUser() {
        readLoginUseCase.execute(object : DisposableObserver<User?>() {
            override fun onNext(user: User?) {
                if (user != null) {
                    mView?.showUserName(user.firstName + user.lastName)
                } else {
                    login()
                }
            }

            override fun onError(e: Throwable?) {
                login()
            }

            override fun onComplete() {

            }
        })
    }

    fun login() {
        loginUseCase.setParams("test@test.com")
        loginUseCase.execute(object : DisposableObserver<User?>() {
            override fun onNext(user: User?) {
                mView?.showUserName(user?.firstName + user?.lastName)
            }

            override fun onError(t: Throwable?) {
                mView?.showUserName(t?.message + "")
            }

            override fun onComplete() {

            }
        })
    }

}