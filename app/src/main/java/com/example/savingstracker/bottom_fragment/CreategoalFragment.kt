package com.example.savingstracker.bottom_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.savingstracker.databinding.FragmentCreategoalBinding
import android.app.DatePickerDialog
import android.app.Dialog
import androidx.fragment.app.DialogFragment
import java.util.Calendar


class CreategoalFragment : DialogFragment() {

    private lateinit var datePickerDialog: DatePickerDialog


    private var _binding: FragmentCreategoalBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCreategoalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btSetDate.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val dateSetListener = DatePickerDialog.OnDateSetListener { _,selectedYear,selectedMonth,selectedDay ->
            val selectedDate = "$selectedYear-${selectedMonth+1}-$selectedDay"
            binding.btSetDate.text = selectedDate
        }

        datePickerDialog = DatePickerDialog(requireContext(),dateSetListener,year,month,day)
        datePickerDialog.show()
    }

}

