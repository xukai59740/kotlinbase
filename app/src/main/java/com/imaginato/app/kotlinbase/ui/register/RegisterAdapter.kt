package com.imaginato.app.kotlinbase.ui.register

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imaginato.app.kotlinbase.R
import com.imaginato.app.kotlinbase.R.id.tv_plan_name
import kotlinx.android.synthetic.main.item_register.view.*

/**
 * Created by img on 2018/10/24.
 */
class RegisterAdapter :RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private var context:Context
    private var plans:MutableList<String> = ArrayList()
    constructor(context: Context) : super(){
        this@RegisterAdapter.context=context
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.item_register,parent,false)
        return ItemViewHolder(view)
    }

    fun setData(plans:MutableList<String>){
        this@RegisterAdapter.plans.clear()
        this@RegisterAdapter.plans.addAll(plans)
    }

    override fun getItemCount(): Int {
        return plans.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var itemViewHolder= holder as ItemViewHolder
        itemViewHolder.itemView?.run{
            tv_plan_name.text=plans.get(position)
        }
    }

    class ItemViewHolder :RecyclerView.ViewHolder{

        constructor(item: View):super(item){

        }
    }

}