package com.example.viktor_ivanov_app

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CardsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private  val cardsImageView: ImageView = itemView.findViewById(R.id.rec_image)

    fun bind(cards: Cards) {
        cardsImageView.setImageResource(cards.image)
    }
}