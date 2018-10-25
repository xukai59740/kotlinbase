package com.imaginato.app.kotlinbase.ui.register

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.databinding.ItemRegisterBinding

/**
 * Created by img on 2018/10/24.
 */
class RegisterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private var context: Context
    private var plans: MutableList<String> = ArrayList()

    constructor(context: Context) : super() {
        this@RegisterAdapter.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var binding = DataBindingUtil.inflate<ItemRegisterBinding>(LayoutInflater.from(context), R.layout.item_register, parent, false)
        return ItemViewHolder(binding)
    }

    fun setData(plans: MutableList<String>) {
        this@RegisterAdapter.plans = plans
    }

    override fun getItemCount(): Int {
        return plans.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var itemViewHolder = holder as ItemViewHolder

        itemViewHolder.itemRegisterBinding.run {
            planName = plans.get(position)
            planImage = R.mipmap.ic_launcher
            visable = true
            clickListener = object : View.OnClickListener {
                override fun onClick(v: View?) {

                }
            }
            executePendingBindings()
        }
    }

    class ItemViewHolder : RecyclerView.ViewHolder {
        var itemRegisterBinding: ItemRegisterBinding

        constructor(itemRegisterBinding: ItemRegisterBinding) : super(itemRegisterBinding.root) {
            this.itemRegisterBinding = itemRegisterBinding
        }
    }

}