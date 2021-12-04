package com.example.viktor_ivanov_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val KEY = "number"

class ActivityInsertData : AppCompatActivity() {

    lateinit var inputRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        val number_consum: Int = intent.getIntExtra(KEY, 0)//получение переданного числа
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        val inputList: MutableList<DataInput> = mutableListOf()

        for(i in 1..number_consum) {
            inputList.add(DataInput(i.toString(), "Enter the Load"))
        }

        /*val inputList:List<DataInput> = listOf(
            DataInput("1", "Enter the Load"),
            DataInput("2", "Enter the Load"),
            DataInput("3", "Enter the Load"),
            DataInput("4", "Enter the Load"),
            DataInput("5", "Enter the Load"),
            DataInput("6", "Enter the Load")
        )*/

        inputRecycler = findViewById(R.id.input_recycler_view)
        inputRecycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
        inputRecycler.adapter = AdapterForInput(inputList)
    }
}