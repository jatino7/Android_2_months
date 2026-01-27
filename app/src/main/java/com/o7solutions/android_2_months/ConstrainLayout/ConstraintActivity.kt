package com.o7solutions.android_2_months.ConstrainLayout

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import androidx.constraintlayout.motion.widget.KeyPosition
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7solutions.android_2_months.R

class ConstraintActivity : AppCompatActivity() {

    lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constraint)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = findViewById<Spinner>(R.id.spinner)

//        list of items in spinner
        val list = arrayListOf<String>("Punjab","Haryana","Rajasthan","Delhi","Himachal Pradesh")


        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,list)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>?,
                p1: View?,
                position: Int,
                p3: Long
            ) {

                val selectedItem = parent?.getItemAtPosition(position)
                
                Toast.makeText(this@ConstraintActivity, "${selectedItem.toString()}", Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }


    }
}