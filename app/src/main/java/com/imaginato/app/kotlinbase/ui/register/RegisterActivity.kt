package com.imaginato.app.kotlinbase.ui.register

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleService
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.databinding.ActivityRegisterBinding
import com.imaginato.app.kotlinbase.model.response.User
import com.imaginato.app.kotlinbase.ui.base.LifecycleActivity
import com.imaginato.app.kotlinbase.ui.register.viewmodel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : LifecycleActivity() {

    lateinit var adapter: RegisterAdapter
    lateinit var lifecycleRegistry: LifecycleRegistry
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ActivityRegisterBinding=DataBindingUtil.setContentView(this,R.layout.activity_register)

        var registerViewModel=RegisterViewModel()

        lifecycleRegistry=LifecycleRegistry(this)
        lifecycleRegistry.addObserver(registerViewModel)

        var user =User()
        user.firstName="kevinxu"
        registerViewModel.user=user

        var plans= arrayListOf<String>()
        plans.add("6Meal")
        plans.add("12Meal")
        plans.add("20Meal")
        plans.add("30Meal")
        plans.add("40Meal")
        plans.add("50Meal")
        registerViewModel.plans=plans

        registerViewModel.clickListener=object:View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@RegisterActivity,tv_register.text.toString(),Toast.LENGTH_LONG).show()
            }
        }

        binding.registerViewModel=registerViewModel

        recy_plans.layoutManager=LinearLayoutManager(this)
        adapter= RegisterAdapter(this)
        recy_plans.adapter=adapter
        adapter.setData(plans)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    interface PlanClickListener{
        fun clickListener(planName:String)
    }
}
