package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    private val _shoesData = MutableLiveData<MutableList<Shoe>>()
    val shoesData: LiveData<MutableList<Shoe>>
        get() = _shoesData


    init {
        _shoesData.value = mutableListOf(SHOE_ONE, SHOE_TWO, SHOE_THREE)
    }

    fun addNewShoe(shoe: Shoe) {
        _shoesData.value?.add(shoe)
        Timber.i("${_shoesData.value}")

    }


    companion object {
        //Pre-Populated Shoes
        val SHOE_ONE =
            Shoe("Chuck Taylor", 10.5, "Converse", "Retro Athletic Shoe", listOf("shoe"))
        val SHOE_TWO =
            Shoe("Charged Assert 8", 12.0, "Under Armour", "Running Shoe", listOf("shoe"))
        val SHOE_THREE =
            Shoe("Nimbus 22", 8.5, "Asics", "Running Shoe", listOf("shoe"))
    }

}