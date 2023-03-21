package com.example.gk_21it108

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(private val ds:ArrayList<Data_21IT108>) :RecyclerView.Adapter<RvAdapter.ViewHolder>(){
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }


    class ViewHolder(itemView: View, clickListener: onItemClickListener):RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listsv_21it108,parent,false)
        return ViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            val svName = findViewById<TextView>(R.id.txtName)
            svName.text = ds[position].svName
            val svMSV = findViewById<TextView>(R.id.txtMsv)
            svMSV.text = ds[position].svMsv
        }
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}
