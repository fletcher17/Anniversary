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
import com.decadev.happyanniversary.ViewModel.ImageClickedViewModel
import com.decadev.happyanniversary.databinding.FragmentImageClickedBinding

class ImageClickedFragment : Fragment() {

    private var _binding: FragmentImageClickedBinding? = null
    private val binding get() = _binding!!

    private val imageViewModel: ImageClickedViewModel by viewModels()
    val args: ImageClickedFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentImageClickedBinding.inflate(layoutInflater, container, false)
        val view = binding.root


        val imageReceived = args.responseImage
        imageReceived?.let {
            imageViewModel.getImageClicked(it)
        }

        imageViewModel.imageItemClicked.observe(viewLifecycleOwner, Observer {
            Glide.with(requireActivity()).load(it.imageUrl).apply(
                RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image)
            ).into(binding.imageViewed)
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}