package com.decadev.happyanniversary.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decadev.happyanniversary.Model.SecondYear.ResponseData

import kotlinx.coroutines.cancel

class SecondImageClickedViewModel : ViewModel() {

    private var _imageClicked = MutableLiveData<ResponseData>()
    val secondImageItemClicked: LiveData<ResponseData> get() = _imageClicked


    fun getSecondImageClicked(itemClicked: ResponseData) {
        _imageClicked.value = itemClicked
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}