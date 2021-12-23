package com.example.viktor_ivanov_app

import android.content.Context
import android.content.Intent
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
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
            Cards(R.drawable.ic_logo_gau, Uri.parse("https://www.orelsau.ru/")),
            Cards(R.drawable.ic_logo_iprs, Uri.parse("https://www.iprbookshop.ru/")),
            Cards(R.drawable.ic_logo_lan, Uri.parse("https://e.lanbook.com/")),
            Cards(R.drawable.ic_logo_urait, Uri.parse("https://urait.ru/"))
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

        bindingClass.editNumConsum.setOnClickListener {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(bindingClass.editNumConsum.windowToken, 0)
        }

        val imageViewOGAU: ImageView= findViewById(R.id.imageView)
        val bitmap = (resources.getDrawable(R.drawable.ic_logo_gau) as BitmapDrawable).bitmap
        val imageRounded = Bitmap.createBitmap(bitmap.width, bitmap.height, bitmap.config)
        val canvas = Canvas(imageRounded)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.shader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        canvas.drawRoundRect(RectF(10F, 10F, bitmap.width.toFloat(), bitmap.height.toFloat()),100F, 100F, paint)
        imageViewOGAU.setImageBitmap(imageRounded)
    }
}
