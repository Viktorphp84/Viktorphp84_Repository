package com.example.viktor_ivanov_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InputFragmentCos : Fragment() {

    private lateinit var inputRecyclerCos: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val viewCos = inflater.inflate(R.layout.fragment_input_cos, container, false)

        val num = arguments?.getInt("num")

        val inputListCos: MutableList<DataInput> = mutableListOf()
        val str: String = resources.getString(R.string.cos)

        for(i in 1..num!!) {
            inputListCos.add(DataInput("$str $i", resources.getString(R.string.binding_enter_cos) ))
        }

        inputRecyclerCos = viewCos.findViewById(R.id.input_recycler_view_cos)
        inputRecyclerCos.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false )
        inputRecyclerCos.adapter = AdapterForInput(inputListCos)

        return viewCos
    }
}