package com.imaginato.app.kotlinbase.ui.base

/**
 * Created by xukai on 2018/10/13.
 */
open class RxPresenter<T : BaseView> : BasePresenter {

    protected var mView: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun attachView(view: BaseView) {
        mView = view as T
    }

    override fun detachView() {
        this.mView = null
    }

}