package com.imaginato.app.kotlinbase.ui.home

import com.imaginato.app.kotlinbase.ui.base.RxPresenter

/**
 * Created by xukai on 2018/10/13.
 */
class HomePresenterImpe: RxPresenter<HomeContract.View>(), HomeContract.Presenter {

    override fun loadUser(){
        mView?.showUserName("kevinxu")
    }

}