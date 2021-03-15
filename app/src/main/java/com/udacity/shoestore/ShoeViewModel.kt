package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

val SHOE_ONE = Shoe("Chuck Taylor", 10.5, "Converse", "Retro Athletic Shoe", listOf("shoe"))
val SHOE_TWO = Shoe("Charged Assert 8", 12.0, "Under Armour", "Running Shoe", listOf("shoe"))
val SHOE_THREE = Shoe("Nimbus 22", 8.5, "Asics", "Running Shoe", listOf("shoe"))

class ShoeViewModel : ViewModel() {

    private val _shoesData = MutableLiveData<List<Shoe>>()
    val shoesData : LiveData<List<Shoe>>
    get() = _shoesData

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe>
    get() = _shoe

    init {
        _shoesData.value = mutableListOf(SHOE_ONE, SHOE_TWO, SHOE_THREE)
    }

}