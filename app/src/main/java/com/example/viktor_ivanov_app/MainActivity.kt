package com.example.viktor_ivanov_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viktor_ivanov_app.databinding.ActivityMainBinding

private const val KEY = "number"

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass:ActivityMainBinding
    private  lateinit var cardsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cardsList: List<Cards> = listOf(
            Cards(R.drawable.ic_logo_gau),
            Cards(R.drawable.ic_logo_iprs),
            Cards(R.drawable.ic_logo_lan),
            Cards(R.drawable.ic_logo_urait)
        )

        bindingClass = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(bindingClass.root)

        cardsRecyclerView = bindingClass.recyclerView
        cardsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        cardsRecyclerView.adapter = CardsAdapter(cardsList)

        //actionBar?.title="Ввод данных"

        bindingClass.button.setOnClickListener{
            val num: Int = bindingClass.editNumConsum.text.toString().toInt()
            val intent: Intent = Intent(this, ActivityInsertData::class.java)

            intent.putExtra(KEY, num)//передача числа из строки ввода в intent
            startActivity(intent)
        }
    }
}
