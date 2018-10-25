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
        binding.registerViewModel=registerViewModel

        registerViewModel.clickListener=object:View.OnClickListener{
            override fun onClick(v: View?) {

                binding.registerViewModel?.let {
                    it.firstName.set("kevin.xu1")
                    it.plans.set(0,"60Meal")
                }
                Toast.makeText(this@RegisterActivity,tv_register.text.toString(),Toast.LENGTH_LONG).show()
            }
        }

        recy_plans.layoutManager=LinearLayoutManager(this)
        adapter= RegisterAdapter(this)
        recy_plans.adapter=adapter
        binding.registerViewModel?.let{
            adapter.setData(it.plans)
        }

        binding.registerViewModel?.run {
            loadData()
        }
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    interface PlanClickListener{
        fun clickListener(planName:String)
    }
}
