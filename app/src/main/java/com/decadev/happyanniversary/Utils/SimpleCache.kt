package com.decadev.happyanniversary.Utils

import com.decadev.happyanniversary.Model.ResponseData

object SimpleCache {

    val pictureCache = mutableMapOf<Int, ResponseData>()
}