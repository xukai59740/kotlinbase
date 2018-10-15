package com.imaginato.app.kotlinbase.ui.home.presenter

import com.imaginato.app.kotlinbase.data.repository.AccountRepository
import com.imaginato.app.kotlinbase.model.response.User
import com.imaginato.app.kotlinbase.ui.base.RxPresenter
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject


/**
 * Created by xukai on 2018/10/13.
 */
class HomePresenterImpl : RxPresenter<HomeContract.View>, HomeContract.Presenter {

    var accountRepository: AccountRepository

    @Inject constructor(accountRepository: AccountRepository) {
        this@HomePresenterImpl.accountRepository = accountRepository
    }

    override fun loadUser() {
        execute(accountRepository.readLogin(),
                object : DisposableObserver<User?>() {
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
        var params = hashMapOf<String, String>()
        params.put("email", "test@test.com")
        execute(accountRepository.login(params),
                object : DisposableObserver<User>() {
                    override fun onNext(user: User) {
                        mView?.showUserName(user.firstName + user.lastName)
                    }

                    override fun onError(t: Throwable) {
                        mView?.showUserName(t.message + "")
                    }

                    override fun onComplete() {

                    }
                }
        )
    }

}