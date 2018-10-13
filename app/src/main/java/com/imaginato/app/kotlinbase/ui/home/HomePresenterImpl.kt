package com.imaginato.app.kotlinbase.ui.home

import com.imaginato.app.kotlinbase.ui.base.RxPresenter
import javax.inject.Inject


/**
 * Created by xukai on 2018/10/13.
 */
class HomePresenterImpl : RxPresenter<HomeContract.View>, HomeContract.Presenter {


    @Inject constructor(){

    }

    override fun loadUser(){
        mView?.showUserName("kevinxu")
    }

}