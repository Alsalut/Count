package com.example.count

import android.content.Context
import java.io.File

class ClassFile(context: Context)
{
    // указываем папку для создания файла (ещё есть папки cash, data и др.)
    val file = context.filesDir

    // путь к файлу
    val path = file.toPath()

    // чтение из файла
    fun readFromFile(nameFile: String, defoltString: String): String
    {
        return if (File("$path/$nameFile").exists())
        {
            File("$path/$nameFile").readText()
        } else
        {
            writeToFile(nameFile, defoltString)
            defoltString
        }
    }

    // запись в файл
    fun writeToFile(nameFile: String, saveString: String)
    { // записываем строку в файл
        File("$path/$nameFile").writeText(saveString)
    }
}