package com.imaginato.app.kotlinbase.ui.viewmodel

import android.databinding.BindingAdapter
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView

/**
 * Created by img on 2018/10/24.
 */
@BindingAdapter("image")
fun ImageView.loadImage(imageView: ImageView, resId:Int){
    imageView.setImageResource(resId)
}

@BindingAdapter("visibleOrGone")
fun View.setVisibleOrGone(show: Boolean) {
    visibility = if (show) VISIBLE else GONE
}