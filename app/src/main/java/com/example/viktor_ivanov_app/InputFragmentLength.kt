package com.example.viktor_ivanov_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InputFragmentLength : Fragment() {

    private lateinit var inputRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val viewLength = inflater.inflate(R.layout.fragment_input_length, container, false)

        val num = arguments?.getInt("num")

        val inputListLength: MutableList<DataInput> = mutableListOf()
        val str: String = resources.getString(R.string.length)

        for(i in 1..num!!) {
            inputListLength.add(DataInput("$str $i", resources.getString(R.string.binding_enter_length) ))
        }

        inputRecycler = viewLength.findViewById(R.id.input_recycler_view_length)
        inputRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false )
        inputRecycler.adapter = AdapterForInput(inputListLength)

        return viewLength
    }
}