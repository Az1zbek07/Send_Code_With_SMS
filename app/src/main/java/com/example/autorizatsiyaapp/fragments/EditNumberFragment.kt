package com.example.autorizatsiyaapp.fragments

import android.os.Bundle
import android.telephony.SmsManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.autorizatsiyaapp.R
import com.example.autorizatsiyaapp.databinding.FragmentEditNumberBinding
import com.google.android.material.snackbar.Snackbar

class EditNumberFragment : Fragment(R.layout.fragment_edit_number) {
    private var _binding: FragmentEditNumberBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentEditNumberBinding.bind(view)

        binding.btnGo.setOnClickListener {
            val number = binding.editNumber.text.toString().trim()

            if (number.length == 9){
                val bundle = bundleOf("number" to number)
                val smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(number, null, "SMS code is kqsy0444", null, null)
                Toast.makeText(requireContext(), "SMS sanded please wait", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_editNumberFragment_to_checkSMSFragment, bundle)
            }else{
                Toast.makeText(requireContext(), "Number is not correct", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}