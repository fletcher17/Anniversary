package com.decadev.happyanniversary.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decadev.happyanniversary.Model.ResponseData
import com.decadev.happyanniversary.Repository.MainRepository
import kotlinx.coroutines.cancel

class ImageClickedViewModel : ViewModel() {

    private var _imageClicked = MutableLiveData<ResponseData>()
    val imageItemClicked: LiveData<ResponseData> get() = _imageClicked


    fun getImageClicked(itemClicked: ResponseData) {
            _imageClicked.value = itemClicked
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}