package com.decadev.happyanniversary.Model

data class PageMetaData(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int
)