package com.imaginato.app.kotlinbase.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by xukai on 2018/10/13.
 */
open abstract class BaseActivity<T : BasePresenter> : AppCompatActivity(), BaseView {

    protected var mPresenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = getPresenter()
        //todo dagger
        mPresenter?.attachView(this)
    }

    abstract fun getPresenter(): T?

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.detachView()
    }

    override fun showProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun closeProgressDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}