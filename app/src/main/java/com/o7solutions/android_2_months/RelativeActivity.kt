package com.o7solutions.android_2_months

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RelativeActivity : AppCompatActivity() {



    lateinit var topTV: TextView
    lateinit var editText: EditText
    lateinit var btn: Button
    lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relative)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        topTV = findViewById<TextView>(R.id.top_tv)
        editText = findViewById<EditText>(R.id.editText)
        btn = findViewById<Button>(R.id.btn)
        btn2 = findViewById<Button>(R.id.btn2)

//222222222
        btn.setOnClickListener {

            topTV.text = "Top Text View"

            Toast.makeText(this, "Text changed!", Toast.LENGTH_SHORT).show()


        }


        btn2.setOnClickListener {

            var message = editText.text.toString()
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
        }


    }
}