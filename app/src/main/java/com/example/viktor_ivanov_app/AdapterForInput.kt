package com.example.viktor_ivanov_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterForInput(val listInput: List<DataInput>): RecyclerView.Adapter<ViewHolderInput>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderInput {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.string_activity, parent, false)
        return  ViewHolderInput(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderInput, position: Int) {
        val lst = listInput[position]
        holder.bind(lst)
    }

    override fun getItemCount(): Int {
        return listInput.size
    }

}