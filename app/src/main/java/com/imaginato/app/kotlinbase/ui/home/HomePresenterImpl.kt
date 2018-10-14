package com.imaginato.app.kotlinbase.ui.home

import com.imaginato.app.kotlinbase.data.RetrofitFactory
import com.imaginato.app.kotlinbase.data.repository.AccountRepository
import com.imaginato.app.kotlinbase.data.repository.AccountRepositoryImpl
import com.imaginato.app.kotlinbase.model.response.User
import com.imaginato.app.kotlinbase.ui.base.RxPresenter
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import javax.inject.Inject


/**
 * Created by xukai on 2018/10/13.
 */
class HomePresenterImpl : RxPresenter<HomeContract.View>, HomeContract.Presenter {

    var accountRepository : AccountRepository

    @Inject constructor(){
        accountRepository=AccountRepositoryImpl(RetrofitFactory.provideAccountApi())
    }

    override fun loadUser(){
        var params = hashMapOf<String, String>()
        params.put("email", "test@test.com")

        execute(accountRepository.login(params),
                object : DisposableObserver<User>() {
                    override fun onNext(user: User) {
                        mView?.showUserName("kevinxu")
                    }

                    override fun onError(t: Throwable) {
                        mView?.showUserName(t.message+"")
                    }

                    override fun onComplete() {

                    }
                }
        )
    }

}