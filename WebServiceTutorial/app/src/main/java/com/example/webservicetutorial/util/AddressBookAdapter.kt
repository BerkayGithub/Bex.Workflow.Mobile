package com.example.webservicetutorial.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.webservicetutorial.R
import com.example.webservicetutorial.databinding.AddressBookRowBinding
import com.example.webservicetutorial.dbentities.entities.GetContactValue

class AddressBookAdapter (
    private val contactValues: List<GetContactValue>
) : RecyclerView.Adapter<AddressBookAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.address_book_row,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
        return contactValues.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowBinding.contactValue == contactValues[position]
    }

    class ViewHolder (
        val rowBinding: AddressBookRowBinding
    ) : RecyclerView.ViewHolder(rowBinding.root)




}