package com.o7solutions.android_2_months.BottomNavigation.ui.home

import android.icu.text.Edits
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.o7solutions.android_2_months.R
import com.o7solutions.android_2_months.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container,false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.datePicker.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Title")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

            datePicker.show(parentFragmentManager,"DATE_PICKER")
            datePicker.addOnPositiveButtonClickListener { selection->


                val dateString = SimpleDateFormat("dd/MMM/yyyy", Locale.getDefault()).format(Date(selection))

                Toast.makeText(requireContext(), dateString, Toast.LENGTH_SHORT).show()

            }
        }

        binding.timePicker.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTitleText("Select Time")
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .build()

            timePicker.show(parentFragmentManager,"TIME_PICKER")

            timePicker.addOnPositiveButtonClickListener {
                val pickedHour = timePicker.hour
                val pickedMinute = timePicker.minute


                Toast.makeText(requireContext(), "$pickedHour: $pickedMinute ", Toast.LENGTH_SHORT).show()
            }


        }



//
        }
}