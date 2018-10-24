package com.imaginato.app.kotlinbase.ui.register

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.databinding.ActivityRegisterBinding
import com.imaginato.app.kotlinbase.model.response.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var adapter: RegisterAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding:ActivityRegisterBinding=DataBindingUtil.setContentView(this,R.layout.activity_register)
        var user =User()
        user.firstName="kevinxu"
        binding.user=user

        var plans= arrayListOf<String>()
        plans.add("6Meal")
        plans.add("12Meal")
        plans.add("20Meal")
        plans.add("30Meal")
        plans.add("40Meal")
        plans.add("50Meal")
        binding.plans=plans

        binding.clickListener=object:View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@RegisterActivity,tv_register.text.toString(),Toast.LENGTH_LONG).show()
            }
        }

        recy_plans.layoutManager=LinearLayoutManager(this)
        adapter= RegisterAdapter(this)
        recy_plans.adapter=adapter
        adapter.setData(plans)
    }

    interface PlanClickListener{
        fun clickListener(planName:String)
    }
}
