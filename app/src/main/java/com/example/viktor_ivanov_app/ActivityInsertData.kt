package com.example.viktor_ivanov_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.children
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viktor_ivanov_app.databinding.ActivityMainBinding

private const val KEY = "number"

class ActivityInsertData : AppCompatActivity() {

    private lateinit var buttonNextFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        val number: Int = intent.getIntExtra(KEY, 0)//получение переданного числа
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        val fragmentConsum = InputFragmentConsum()
        val fragmentCos = InputFragmentCos()
        val fragmentLength = InputFragmentLength()

        supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container_view, fragmentConsum). //addToBackStack(fragment.tag).//при нажатии кнопки домой экраны запоминаются как в стеке
        commit()

        fragmentConsum.arguments = bundleOf(Pair("num", number))

        buttonNextFragment = findViewById(R.id.button_next_frag)

        buttonNextFragment.setOnClickListener{
            val fragment =
                when(supportFragmentManager.findFragmentById(R.id.fragment_container_view)) {
                    is InputFragmentConsum -> fragmentCos
                    is InputFragmentCos -> fragmentLength
                    else -> fragmentConsum
                }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment).commit()

            fragment.arguments = bundleOf(Pair("num", number))
        }
    }
}