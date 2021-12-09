package com.example.viktor_ivanov_app

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CardsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private  val cardsImageView: ImageView = itemView.findViewById(R.id.rec_image)

    fun bind(cards: Cards) {
        cardsImageView.setImageResource(cards.image)
        itemView.setOnClickListener {
            val link = Uri.parse(cards.link.toString())
            val intent = Intent(Intent.ACTION_VIEW, link)
            itemView.context.startActivity(intent)
        }
    }
}