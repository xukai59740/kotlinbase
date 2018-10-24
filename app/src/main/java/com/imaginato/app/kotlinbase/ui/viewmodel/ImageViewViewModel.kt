package com.imaginato.app.kotlinbase.ui.viewmodel

import android.databinding.BindingAdapter
import android.widget.ImageView

/**
 * Created by img on 2018/10/24.
 */
@BindingAdapter("image")
fun loadImage(imageView: ImageView, resId:Int){
    imageView.setImageResource(resId)
}
