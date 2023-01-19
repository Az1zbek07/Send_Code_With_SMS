package com.example.autorizatsiyaapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autorizatsiyaapp.R
import com.example.autorizatsiyaapp.databinding.FragmentCheckSMSBinding
import com.example.autorizatsiyaapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        val number = arguments?.getString("number")
        binding.textNumber.text = number
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}