package com.imaginato.app.kotlinbase.ui.databinding

import android.databinding.BindingAdapter
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView

/**
 * Created by img on 2018/10/24.
 */
@BindingAdapter("image")
fun loadImage(imageView: ImageView, resId:Int){
    imageView.setImageResource(resId)
}

@BindingAdapter("visible_gone")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}