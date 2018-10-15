package com.imaginato.app.kotlinbase.ui.home

import android.os.Bundle
import com.imaginato.app.kotlinbase.BuildConfig
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.injection.component.DaggerPresenterComponent
import com.imaginato.app.kotlinbase.ui.base.BaseActivity
import com.imaginato.app.kotlinbase.ui.base.BaseApplication
import com.imaginato.app.kotlinbase.ui.home.presenter.HomeContract
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomeContract.Presenter>(), HomeContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tvContent.setText(BuildConfig.BASE_SERVER)
        mPresenter?.loadUser()
    }

    override fun showUserName(userName: String) {
        tvContent.setText(userName)
    }


    override fun initInject() {
        DaggerPresenterComponent.builder()
                .singletonComponent(BaseApplication.singletonComponent)
                .build()
                .inject(this)
    }
}
