package com.example.bexflow.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bexflow.`object`.Message
import com.example.bexflow.R
import com.example.bexflow.databinding.MyRowBinding

class MyAdapter (
    private val messages: ArrayList<Message>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.myRowBinding.message = messages[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.my_row,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return messages.size
    }

    class MyViewHolder(
        val myRowBinding: MyRowBinding
    ) : RecyclerView.ViewHolder(myRowBinding.root)
}