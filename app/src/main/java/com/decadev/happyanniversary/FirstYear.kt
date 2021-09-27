package com.decadev.happyanniversary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.decadev.happyanniversary.Adapter.FirstYearAdapter
import com.decadev.happyanniversary.ClickListener.ImageClickListener
import com.decadev.happyanniversary.Model.ResponseData
import com.decadev.happyanniversary.ViewModel.FirstYearViewModel
import com.decadev.happyanniversary.ViewModel.ImageClickedViewModel
import com.decadev.happyanniversary.databinding.FragmentFirstYearBinding


class FirstYear : Fragment(), ImageClickListener {

    private var _binding: FragmentFirstYearBinding? = null
    private val binding get() = _binding!!

    lateinit var firstYearRecyclerView: RecyclerView
    lateinit var firstYearAdapter: FirstYearAdapter

    val firstViewModel: FirstYearViewModel by viewModels()
    private val imageViewModel: ImageClickedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstYearBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        firstYearRecyclerView = binding.firstYearRecyclerView

        firstViewModel.allFirstYear.observe(viewLifecycleOwner, Observer {
            firstYearAdapter = FirstYearAdapter(it.data.responseData, this)
            firstYearRecyclerView.adapter = firstYearAdapter
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemClicked(imageclicked: ResponseData) {
       imageViewModel.getImageClicked(imageclicked)
        val action = FirstYearDirections.actionFirstYearToImageClickedFragment(imageclicked)
        findNavController().navigate(action)
    }
}