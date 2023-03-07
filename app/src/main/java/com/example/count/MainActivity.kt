package com.example.count

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.count.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    // объявление переменных
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // прямой доступ к Виджетам
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // выполнится при нажатии на кнопку
        setListeners()
    }

    // выполнится при нажатии на кнопку
    private fun setListeners()
    {
        // при нажатии на кнопку btnDuolingo
        binding.btnDuolingo.setOnClickListener { // переход на CountDuolingo Activity
            val intentDuolingo = Intent(this, CountDuolingo::class.java)
            startActivity(intentDuolingo)
        }
    }

    // выход из приложения при жесте "Назад"
    @Deprecated("Deprecated in Java")
    override fun onBackPressed()
    {
        finishAndRemoveTask()
    }
}