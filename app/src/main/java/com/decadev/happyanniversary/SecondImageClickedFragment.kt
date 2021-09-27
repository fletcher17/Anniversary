package com.decadev.happyanniversary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.decadev.happyanniversary.ViewModel.SecondImageClickedViewModel
import com.decadev.happyanniversary.databinding.FragmentSecondImageClickedBinding


class SecondImageClickedFragment : Fragment() {

    private var _binding: FragmentSecondImageClickedBinding? = null
    private val binding get() = _binding!!

    private val secondImageClickedViewModel: SecondImageClickedViewModel by viewModels()
    private val args: SecondImageClickedFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentSecondImageClickedBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        val secondImageReceived = args.secondImageResponse
        secondImageReceived?.let {
            secondImageClickedViewModel.getSecondImageClicked(it)
        }


        secondImageClickedViewModel.secondImageItemClicked.observe(viewLifecycleOwner, Observer {
            Glide.with(view).load(it.imageUrl).apply(RequestOptions().placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)).into(binding.secondYearImageViewed)
        })

        return view
    }

}