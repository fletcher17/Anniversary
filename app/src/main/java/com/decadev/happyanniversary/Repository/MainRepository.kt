package com.decadev.happyanniversary.Repository

import com.decadev.happyanniversary.Model.Data
import com.decadev.happyanniversary.Model.FirstYearList
import com.decadev.happyanniversary.Model.SecondYear.SecondYearList
import com.decadev.happyanniversary.Retrofit.RetrofitClient.apiService

class MainRepository {

    suspend fun getAllFirstYear() : FirstYearList {
        var res = apiService.getYearOne()
        return res
    }

    suspend fun getAllSecondYear() : SecondYearList {
        var res2 = apiService.getYearTwo()
        return res2
    }
}