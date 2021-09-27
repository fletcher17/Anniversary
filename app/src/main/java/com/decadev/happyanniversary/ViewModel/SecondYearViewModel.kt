package com.decadev.happyanniversary.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.decadev.happyanniversary.Model.SecondYear.SecondYearList
import com.decadev.happyanniversary.Repository.MainRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondYearViewModel : ViewModel() {

    var mainRepository : MainRepository

    private var _allSecondYear = MutableLiveData<SecondYearList>()
    val allSecondYear: LiveData<SecondYearList> get() = _allSecondYear

    init {
        mainRepository = MainRepository()
        getAllSecondYearFromRepository()
    }

    private fun getAllSecondYearFromRepository() {
        viewModelScope.launch(IO) {
            val getPicture = mainRepository.getAllSecondYear()
            withContext(Main) {
                try {
                    getPicture.let {
                        _allSecondYear.value = getPicture
                    }
                } catch (e: Throwable) {
                    _allSecondYear.value = null
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}