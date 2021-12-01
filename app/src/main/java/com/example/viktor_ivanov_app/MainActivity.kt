package com.example.viktor_ivanov_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.viktor_ivanov_app.databinding.ActivityMainBinding

private const val KEY = "number"

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(bindingClass.root)

        //actionBar?.title="Ввод данных"
        //используем элементы
        // bindingClass.textView.text="Здрасте!"
    }

    override fun onStart() {
        Log.d("MyLog", "OnStart")
        super.onStart()

    }

    override fun onPause() {
        Log.d("MyLog", "OnPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("MyLog", "OnStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d("MyLog", "OnRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d("MyLog", "OnDestroy")
        super.onDestroy()
    }

    fun onClickTest(view: View) {
        bindingClass = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(bindingClass.root)

        val intent: Intent = Intent(this, ActivityInsertData::class.java)
        val num: Int = bindingClass.editNumConsum.text.toString().toInt()

        intent.putExtra(KEY, num)//передача числа из строки ввода в intent
        startActivity(intent)
    }
}
