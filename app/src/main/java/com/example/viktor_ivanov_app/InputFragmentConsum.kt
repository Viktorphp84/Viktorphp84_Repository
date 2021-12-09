package com.example.viktor_ivanov_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ResourceBundle.getBundle

class InputFragmentConsum : Fragment() {

    private lateinit var inputRecycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_input_consum, container, false)

        val num = arguments?.getInt("num")

        val inputList: MutableList<DataInput> = mutableListOf()
        val str: String = resources.getString(R.string.load)

        for(i in 1..num!!) {
            inputList.add(DataInput("$str $i", resources.getString(R.string.binding_enter_load) ))
        }

        inputRecycler = view.findViewById(R.id.input_recycler_view)
        inputRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false )
        inputRecycler.adapter = AdapterForInput(inputList)

        return view
    }
}