package com.example.travelapp.arch

import Attractions
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttractionViewModel : ViewModel() {

    private val repository = AttractionsRepository()
    val attractionViewModelLiveData = MutableLiveData<List<Attractions>>()
    val attractionSelectedLiveData = MutableLiveData<Attractions>()
    val locationLiveData = MutableLiveData<Attractions>()
    fun init(context: Context){
        val attractionlist = repository.parseAttractions(context)
        attractionViewModelLiveData.postValue(attractionlist)
    }

    fun onSelectedLiveData(attractionId : String){
        val attraction = attractionViewModelLiveData.value?.find {
            it.id == attractionId
        } ?: return

        attractionSelectedLiveData.postValue(attraction)
    }
}