package com.decadev.happyanniversary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.decadev.happyanniversary.databinding.FragmentAnniversaryBinding


class AnniversaryFragment : Fragment() {
        private var _binding: FragmentAnniversaryBinding? = null
        private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAnniversaryBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        binding.anniversaryButtonView.setOnClickListener {
            findNavController().navigate(R.id.messageFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}