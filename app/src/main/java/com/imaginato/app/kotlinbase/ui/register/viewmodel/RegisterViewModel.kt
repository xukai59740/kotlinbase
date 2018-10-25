package com.imaginato.app.kotlinbase.ui.register.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.util.Log
import android.view.View

/**
 * Created by img on 2018/10/25.
 */
open class RegisterViewModel : LifecycleObserver {
    var plans: ObservableArrayList<String> = ObservableArrayList()
    var firstName: ObservableField<String> = ObservableField()
    lateinit var clickListener: View.OnClickListener

    fun loadData() {
        firstName.set("kevin.xu")

        plans.add("6Meal")
        plans.add("12Meal")
        plans.add("20Meal")
        plans.add("30Meal")
        plans.add("40Meal")
        plans.add("50Meal")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        Log.d("kevin", "destroy")
    }
}