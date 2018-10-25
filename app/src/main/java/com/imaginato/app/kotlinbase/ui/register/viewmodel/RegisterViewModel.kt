package com.imaginato.app.kotlinbase.ui.register.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import android.view.View
import com.imaginato.app.kotlinbase.model.response.User

/**
 * Created by img on 2018/10/25.
 */
class RegisterViewModel:LifecycleObserver {
    lateinit var plans: ArrayList<String>
    lateinit var user: User
    lateinit var clickListener: View.OnClickListener

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start(){
        Log.d("kevin","ON_START")
    }
}