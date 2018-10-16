package com.imaginato.app.kotlinbase.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.imaginato.app.kotlinbase.BuildConfig
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.injection.component.DaggerPresenterComponent
import com.imaginato.app.kotlinbase.ui.base.BaseActivity
import com.imaginato.app.kotlinbase.ui.base.BaseApplication
import com.imaginato.app.kotlinbase.ui.home.presenter.HomeContract
import com.imaginato.app.kotlinbase.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomeContract.Presenter>(), HomeContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tvContent.setText(BuildConfig.BASE_SERVER)
        tvContent.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                var intent= Intent(this@HomeActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        })
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
