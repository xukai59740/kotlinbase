package com.imaginato.app.kotlinbase.base

/**
 * Created by xukai on 2018/10/13.
 */
open class RxPresenter<T : BaseView> : BasePresenter {

    protected var mView: T? = null

    override fun attachView(view: BaseView) {
        mView = view as T
    }

    override fun detachView() {
        this.mView = null
    }
}