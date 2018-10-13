package com.imaginato.app.kotlinbase.ui.home

import com.imaginato.app.kotlinbase.ui.base.BasePresenter
import com.imaginato.app.kotlinbase.ui.base.BaseView

/**
 * Created by xukai on 2018/10/13.
 */
 interface HomeContract {

     interface View : BaseView {
         fun showUserName(userName:String)
    }

     interface Presenter : BasePresenter {

         fun loadUser()

    }
}