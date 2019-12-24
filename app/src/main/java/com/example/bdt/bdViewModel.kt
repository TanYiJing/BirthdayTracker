package com.example.bdt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class bdViewModel(application: Application) : AndroidViewModel(application) {
   private val BDRepository :bdRepository

    val allBDs : LiveData<List<DB>>

    init {
        val bdDao = bdDatabase.getInstance(application).bddaoVal()
        BDRepository = bdRepository(bdDao)
        allBDs = BDRepository.bddao_val

    }

    fun insertBD(bd:DB)= viewModelScope.launch {
        BDRepository.insertBD(bd)
    }
}