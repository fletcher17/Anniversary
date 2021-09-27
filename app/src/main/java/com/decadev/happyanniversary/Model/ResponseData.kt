package com.decadev.happyanniversary.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseData(
    val dateCreated: String,
    val dateUpdated: String,
    val id: String,
    val imageUrl: String,
    val publicId: String,
    val year: String
) : Parcelable