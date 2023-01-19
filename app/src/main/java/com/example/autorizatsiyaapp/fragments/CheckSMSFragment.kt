package com.example.autorizatsiyaapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.autorizatsiyaapp.R
import com.example.autorizatsiyaapp.databinding.FragmentCheckSMSBinding
import com.example.autorizatsiyaapp.databinding.FragmentEditNumberBinding

class CheckSMSFragment : Fragment(R.layout.fragment_check_s_m_s) {
    private var _binding: FragmentCheckSMSBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCheckSMSBinding.bind(view)
        val number = arguments?.getString("number")

        binding.btnCheck.setOnClickListener {
            val code = binding.editCode.text.toString().trim()

            if (code == "kqsy0444"){
                val bundle = bundleOf("number" to number)
                findNavController().navigate(R.id.action_checkSMSFragment_to_homeFragment, bundle)
            }else{
                Toast.makeText(requireContext(), "Code is not correct", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}