package com.imaginato.app.kotlinbase.ui.register

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.databinding.ActivityRegisterBinding
import com.imaginato.app.kotlinbase.model.response.User
import kotlinx.android.synthetic.main.activity_register.*

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

        binding.clickListener=object:View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(this@RegisterActivity,tv_register.text.toString(),Toast.LENGTH_LONG).show()
            }
        }
    }

    interface PlanClickListener{
        fun clickListener(planName:String)
    }
}
