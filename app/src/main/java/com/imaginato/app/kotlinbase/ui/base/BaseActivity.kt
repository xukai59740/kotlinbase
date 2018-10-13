package com.imaginato.app.kotlinbase.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

/**
 * Created by xukai on 2018/10/13.
 */
abstract class BaseActivity<T : BasePresenter> : AppCompatActivity(), BaseView {

    //must use JvmField, java can access kotlin
    @JvmField
    @Inject var mPresenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInject()
        mPresenter?.attachView(this)
    }

    abstract fun initInject()

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