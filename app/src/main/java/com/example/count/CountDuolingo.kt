package com.example.count

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.example.count.databinding.ActivityCountDuolingoBinding

class CountDuolingo : AppCompatActivity()
{
    // объявление переменных
    lateinit var bindingDuolingo: ActivityCountDuolingoBinding

    // присваиваем переменной название файла
    lateinit var nameFile: String

    // значение по-умолчанию
    private val defoltString = "1"

    // объявляем переменную для текущего значения TextView
    private lateinit var textNow: String

    // объявляем объект класса ClassFile
    lateinit var objectClassFile: ClassFile

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_duolingo)

        nameFile = getString(R.string.doulingo)

        // создаём объект класса ClassFile
        objectClassFile = ClassFile(application)

        // прямой доступ к Виджетам
        bindingDuolingo = ActivityCountDuolingoBinding.inflate(layoutInflater)
        val view = bindingDuolingo.root
        setContentView(view)

        // получаем номер из файла
        textNow = objectClassFile.readFromFile(nameFile, defoltString)

        // отображаем в TextView текущее значение
        bindingDuolingo.tvDuolingo.text = textNow

        // выполнится при нажатии на кнопку
        setListeners()
    }

    // выполнится при нажатии на кнопку
    @SuppressLint("ClickableViewAccessibility", "UseCompatLoadingForDrawables", "SetTextI18n")
    private fun setListeners()
    {
        // при нажатии на кнопку btnDelDuolingo
        bindingDuolingo.btnDelDuolingo.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN)
            {
                // изменяем картинку кнопки для эффекта нажатия
                bindingDuolingo.btnDelDuolingo.setImageDrawable(getDrawable(R.drawable.btn_del_light_256))

                // отображаем в TextView значение 1
                bindingDuolingo.tvDuolingo.text = defoltString

                // записываем номер в файл
                objectClassFile.writeToFile(nameFile, defoltString)
            }

            return@setOnTouchListener false
        }

        // при отпускании кнопки btnDelDuolingo
        bindingDuolingo.btnDelDuolingo.setOnClickListener {
            // изменяем картинку кнопки для эффекта нажатия
            bindingDuolingo.btnDelDuolingo.setImageDrawable(getDrawable(R.drawable.btn_del_dark_256))
        }

        // при нажатии на кнопку btnPlusDuolingo
        bindingDuolingo.btnPlusDuolingo.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN)
            {
                // изменяем картинку кнопки для эффекта нажатия
                bindingDuolingo.btnPlusDuolingo.setImageDrawable(getDrawable(R.drawable.btn_plus_light_256))

                // отображаем в TextView текущее значение
                textNow = (bindingDuolingo.tvDuolingo.text.toString().toInt() + 1).toString()
                bindingDuolingo.tvDuolingo.text = textNow


                // записываем текущее значение в файл
                objectClassFile.writeToFile(nameFile, textNow)
            }

            return@setOnTouchListener false
        }

        // при отпускании кнопки btnPlusDuolingo
        bindingDuolingo.btnPlusDuolingo.setOnClickListener {
            // изменяем картинку кнопки для эффекта нажатия
            bindingDuolingo.btnPlusDuolingo.setImageDrawable(getDrawable(R.drawable.btn_plus_dark_256))
        }
    }
}