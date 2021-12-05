package com.example.viktor_ivanov_app

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolderInput(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.textForInput)
    private  val nameEditText: EditText = itemView.findViewById(R.id.editTextForInput)

    fun bind(data: DataInput) {
        nameTextView.text = "${data.str}"
        nameEditText.setText(data.nameEdit)
    }
}