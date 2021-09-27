package com.decadev.happyanniversary.Retrofit

import com.decadev.happyanniversary.Model.Data
import com.decadev.happyanniversary.Model.FirstYearList
import com.decadev.happyanniversary.Model.SecondYear.SecondYearList
import retrofit2.http.GET

interface ApiService {

    @GET("year/first")
    suspend fun getYearOne(): FirstYearList

    @GET("year/second")
    suspend fun getYearTwo(): SecondYearList
}