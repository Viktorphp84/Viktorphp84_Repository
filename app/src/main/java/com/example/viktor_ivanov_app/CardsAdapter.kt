package com.example.viktor_ivanov_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CardsAdapter(private val cardsList: List<Cards>):
    RecyclerView.Adapter<CardsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
        return CardsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val cards = cardsList[position]
        holder.bind(cards)
    }

    override fun getItemCount(): Int {
        return cardsList.size
    }

}