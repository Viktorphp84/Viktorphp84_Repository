package com.example.viktor_ivanov_app


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment


private const val KEY = "number"
private val CONSUM_FRAGMENT = InputFragmentConsum().javaClass.name
private val COS_FRAGMENT = InputFragmentConsum().javaClass.name
private val LENGTH_FRAGMENT = InputFragmentConsum().javaClass.name

class ActivityInsertData : AppCompatActivity() {

    private lateinit var buttonNextFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        val number: Int = intent.getIntExtra(KEY, 0)//получение переданного числа
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_data)

        val fragmentConsum = InputFragmentConsum()
        val fragmentCos = InputFragmentCos()
        val fragmentLength = InputFragmentLength()

        var fragment: Fragment? = null

        when(supportFragmentManager.findFragmentById(R.id.fragment_container_view)) {
            is InputFragmentConsum ->
                fragment = if(savedInstanceState != null) {
                    supportFragmentManager.getFragment(savedInstanceState, CONSUM_FRAGMENT)
                } else {
                    fragmentCos
                }
            is InputFragmentCos ->
                fragment = if(savedInstanceState != null) {
                    supportFragmentManager.getFragment(savedInstanceState, COS_FRAGMENT)
                } else {
                    fragmentCos
                }
            is InputFragmentLength ->
                fragment = if(savedInstanceState != null) {
                    supportFragmentManager.getFragment(savedInstanceState, LENGTH_FRAGMENT)
                } else {
                    fragmentLength
                }
            else -> fragment = fragmentConsum
        }
        
        supportFragmentManager.beginTransaction().
        replace(R.id.fragment_container_view, fragment!!). //addToBackStack(fragment.tag).//при нажатии кнопки домой экраны запоминаются как в стеке
        commit()

        fragmentConsum.arguments = bundleOf(Pair("num", number))

        buttonNextFragment = findViewById(R.id.button_next_frag)

        buttonNextFragment.setOnClickListener{
            fragment =
                when(supportFragmentManager.findFragmentById(R.id.fragment_container_view)) {
                    is InputFragmentConsum -> fragmentCos
                    is InputFragmentCos -> fragmentLength
                    else -> fragmentConsum
                }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment!!).commit()

            fragment?.arguments = bundleOf(Pair("num", number))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val currentFragment = supportFragmentManager.fragments.last()

        supportFragmentManager.putFragment(outState, currentFragment.javaClass.name, currentFragment)
    }
}