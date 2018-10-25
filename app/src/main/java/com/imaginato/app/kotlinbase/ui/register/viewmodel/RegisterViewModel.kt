package com.imaginato.app.kotlinbase.ui.register.viewmodel

import android.view.View
import com.imaginato.app.kotlinbase.model.response.User

/**
 * Created by img on 2018/10/25.
 */
class RegisterViewModel {
    lateinit var plans: ArrayList<String>
    lateinit var user: User
    lateinit var clickListener: View.OnClickListener
}