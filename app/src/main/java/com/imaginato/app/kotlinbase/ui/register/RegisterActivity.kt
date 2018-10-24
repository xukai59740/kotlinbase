package com.imaginato.app.kotlinbase.ui.register

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.databinding.ActivityRegisterBinding
import com.imaginato.app.kotlinbase.model.response.User

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ActivityRegisterBinding=DataBindingUtil.setContentView(this,R.layout.activity_register)
        var user =User()
        user.firstName="kevinxu"
        binding.user=user

        var plans= arrayListOf<String>()
        plans.add("6Meal")
        binding.plans=plans
    }
}
