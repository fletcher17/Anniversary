package com.decadev.happyanniversary.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decadev.happyanniversary.Model.Data
import com.decadev.happyanniversary.Model.FirstYearList
import com.decadev.happyanniversary.Repository.MainRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FirstYearViewModel : ViewModel() {

    var mainRepository: MainRepository

    enum class ImageResponseState { LOADING, SUCCESS, FAILURE }

    private var _status = MutableLiveData<ImageResponseState>()
    val status : LiveData<ImageResponseState> get() = _status

    private var _allFirstYear = MutableLiveData<FirstYearList>()
    val allFirstYear: LiveData<FirstYearList> get() = _allFirstYear


    init {
        mainRepository = MainRepository()
        getAllFirstYearFromRepository()
    }

    private fun getAllFirstYearFromRepository() {
        viewModelScope.launch(IO) {
            val getPictures = mainRepository.getAllFirstYear()
            withContext(Main) {
                try {
                    getPictures.let {
                        _allFirstYear.value = getPictures
                    }
                } catch (e: Throwable) {
                    _allFirstYear.value = null
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}