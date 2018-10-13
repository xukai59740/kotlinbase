package com.imaginato.app.kotlinbase

import com.imaginato.app.kotlinbase.base.BasePresenter
import com.imaginato.app.kotlinbase.base.BaseView

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