package com.o7solutions.android_2_months.Firebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.o7solutions.android_2_months.R
import com.o7solutions.android_2_months.databinding.ActivityDatabaseBinding

class DatabaseActivity : AppCompatActivity() {


    lateinit var binding: ActivityDatabaseBinding
    var db = Firebase.database.getReference()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.submitBtn.setOnClickListener {
            addEmployee()
        }

        getEmployeeData()
    }


    fun addEmployee() {

        var name = binding.name.text.toString()
        var address = binding.address.text.toString()


        var emp = Employee(name,address)
        db.child("users").child("1234").setValue(emp)
            .addOnSuccessListener {
                Toast.makeText(this, "Data added Successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e->

                Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()

            }

    }

    fun getEmployeeData() {

        var ref = db.child("users").child("1234")

        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                val emp = snapshot.getValue(Employee::class.java)

                Toast.makeText(this@DatabaseActivity, emp.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DatabaseActivity, error.message, Toast.LENGTH_SHORT).show()
            }

        })

    }
}