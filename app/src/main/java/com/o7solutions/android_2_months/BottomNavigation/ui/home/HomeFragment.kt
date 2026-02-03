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
import com.o7solutions.android_2_months.R
import com.o7solutions.android_2_months.databinding.FragmentHomeBinding

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


        val dialog = BottomSheetDialog(requireContext())

        val view = layoutInflater.inflate(R.layout.bottom_sheet_layout,null)

        view.findViewById<Button>(R.id.submitBtn).setOnClickListener {
            var name = view.findViewById<EditText>(R.id.nameET)
            var age = view.findViewById<EditText>(R.id.ageET)

            if(name.text.toString().isEmpty()) {
                name.error = "Please fill name"
            } else if(age.text.toString().isEmpty()) {
                age.error = "Please fill age"
            } else {
                Toast.makeText(requireContext(), "Submitted", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        view.findViewById<Button>(R.id.closeBtn).setOnClickListener {
            dialog.dismiss()
        }

        dialog.setContentView(view)
        dialog.show()
    }
}