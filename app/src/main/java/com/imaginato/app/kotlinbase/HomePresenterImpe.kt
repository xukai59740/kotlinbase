package com.imaginato.app.kotlinbase

import com.imaginato.app.kotlinbase.base.RxPresenter

/**
 * Created by xukai on 2018/10/13.
 */
class HomePresenterImpe: RxPresenter<HomeContract.View>(),HomeContract.Presenter {

    override fun loadUser(){
        mView?.showUserName("kevinxu")
    }

}