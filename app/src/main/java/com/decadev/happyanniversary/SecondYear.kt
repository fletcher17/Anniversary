package com.decadev.happyanniversary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decadev.happyanniversary.Adapter.SecondYearAdapter
import com.decadev.happyanniversary.ClickListener.SecondImageClickListener
import com.decadev.happyanniversary.Model.SecondYear.ResponseData
import com.decadev.happyanniversary.ViewModel.SecondImageClickedViewModel
import com.decadev.happyanniversary.ViewModel.SecondYearViewModel
import com.decadev.happyanniversary.databinding.FragmentSecondYearBinding

class SecondYear : Fragment(), SecondImageClickListener {

    private var _binding: FragmentSecondYearBinding? = null
    private val binding get() = _binding!!

    lateinit var secondRecyclerView: RecyclerView
    lateinit var secondAdapter: SecondYearAdapter

    private val secondViewModel: SecondYearViewModel by viewModels()
    val secondYearImageViewModel: SecondImageClickedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondYearBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        secondRecyclerView = binding.secondYearRecyclerView

        secondViewModel.allSecondYear.observe(viewLifecycleOwner, Observer {
            secondAdapter = SecondYearAdapter(it.data.responseData, this)
            secondRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            secondRecyclerView.adapter = secondAdapter
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemClicked(imageItemClicked: ResponseData) {
        secondYearImageViewModel.getSecondImageClicked(imageItemClicked)
        val actionImage = SecondYearDirections.actionSecondYearToSecondImageClickedFragment(imageItemClicked)
        findNavController().navigate(actionImage)
    }
}