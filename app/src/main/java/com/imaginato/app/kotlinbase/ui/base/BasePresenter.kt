package com.imaginato.app.kotlinbase.ui.base

/**
 * Created by xukai on 2018/10/13.
 */
interface BasePresenter {

    fun attachView(view: BaseView)

    fun detachView()

}