package com.example.viktor_ivanov_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

private const val KEY = "number"

class ActivityInsertData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val number_consum: Int = intent.getIntExtra(KEY, 0)//получение переданного числа
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        for(i in 1..number_consum) {
            val myView: View = layoutInflater.inflate(R.layout.custom_string_layout, null)//создаем вьюшку из кастомного лайоута
            val text = myView.findViewById<TextView>(R.id.text_view)
            val input_number = myView.findViewById<EditText>(R.id.input_num)
            val rel = this.findViewById<LinearLayout>(R.id.rel_lay)
            rel.addView(myView)
        }
    }
}