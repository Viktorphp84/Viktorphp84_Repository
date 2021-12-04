package com.example.viktor_ivanov_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viktor_ivanov_app.databinding.ActivityMainBinding

private const val KEY = "number"

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(bindingClass.root)

        //actionBar?.title="Ввод данных"

        bindingClass.button.setOnClickListener{
            val num: Int = bindingClass.editNumConsum.text.toString().toInt()
            val intent: Intent = Intent(this, ActivityInsertData::class.java)

            intent.putExtra(KEY, num)//передача числа из строки ввода в intent
            startActivity(intent)
        }
    }
}
