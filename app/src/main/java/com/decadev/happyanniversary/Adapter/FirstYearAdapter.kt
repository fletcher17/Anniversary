package com.decadev.happyanniversary.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.decadev.happyanniversary.ClickListener.ImageClickListener
import com.decadev.happyanniversary.Model.ResponseData
import com.decadev.happyanniversary.R
import com.decadev.happyanniversary.databinding.FirstYearBinding

class FirstYearAdapter(val firstResponse: List<ResponseData>, var itemClicked: ImageClickListener) : RecyclerView.Adapter<FirstYearAdapter.FirstYearViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstYearViewHolder {
       val binding = FirstYearBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FirstYearViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstYearViewHolder, position: Int) {
        val firstList = firstResponse[position]

        holder.bind(firstList, itemClicked)
    }

    override fun getItemCount(): Int = firstResponse.size

    inner class FirstYearViewHolder(private val binding: FirstYearBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pics : ResponseData, imageClickListener: ImageClickListener) {
            Glide.with(binding.root).load(pics.imageUrl).apply(
                RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image)
            ).into(binding.imageInFirstYear)

            binding.imageInFirstYear.setOnClickListener {
                imageClickListener.itemClicked(pics)
            }
        }

    }

}