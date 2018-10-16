package com.imaginato.app.kotlinbase.ui.login

import android.os.Bundle
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.injection.component.DaggerPresenterComponent
import com.imaginato.app.kotlinbase.ui.base.BaseActivity
import com.imaginato.app.kotlinbase.ui.base.BaseApplication
import com.imaginato.app.kotlinbase.ui.home.presenter.HomeContract
import com.imaginato.app.kotlinbase.ui.home.presenter.LoginContract
import kotlinx.android.synthetic.main.activity_home.*

class LoginActivity : BaseActivity<LoginContract.Presenter>(), LoginContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tvContent.setText("Login")
    }

    override fun initInject() {
        DaggerPresenterComponent.builder()
                .singletonComponent(BaseApplication.singletonComponent)
                .build()
                .inject(this)
    }
}
