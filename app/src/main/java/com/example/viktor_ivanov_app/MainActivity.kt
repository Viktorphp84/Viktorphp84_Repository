package com.example.viktor_ivanov_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viktor_ivanov_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass= ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(bindingClass.root)

        //используем элементы
        bindingClass.textView.text="ghgjg"
    }
}
