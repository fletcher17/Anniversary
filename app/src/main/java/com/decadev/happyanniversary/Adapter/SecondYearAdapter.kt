package com.decadev.happyanniversary.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.decadev.happyanniversary.ClickListener.SecondImageClickListener
import com.decadev.happyanniversary.Model.SecondYear.ResponseData
import com.decadev.happyanniversary.R
import com.decadev.happyanniversary.databinding.SecondYearBinding


class SecondYearAdapter(val secondResponse: List<ResponseData>, var itemPicture: SecondImageClickListener) : RecyclerView.Adapter<SecondYearAdapter.SecondYearViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondYearViewHolder {
        val binding = SecondYearBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SecondYearViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondYearViewHolder, position: Int) {
        val pictureRes = secondResponse[position]

        holder.bind(pictureRes, itemPicture)
    }

    override fun getItemCount(): Int = secondResponse.size

    inner class SecondYearViewHolder(private val binding: SecondYearBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pictureResponse: ResponseData, imageclicked: SecondImageClickListener) {
            Glide.with(binding.root).load(pictureResponse.imageUrl).apply(
                RequestOptions().placeholder(R.drawable.loading_animation).error(R.drawable.ic_broken_image)
            ).into(binding.imageInSecondYear)

            binding.imageInSecondYear.setOnClickListener {
                imageclicked.itemClicked(pictureResponse)
            }
        }
    }
}