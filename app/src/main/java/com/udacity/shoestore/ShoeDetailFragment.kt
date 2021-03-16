package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container,false)
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.cancelButton.setOnClickListener {
            navigateToShoeList()
        }

        binding.saveButton.setOnClickListener {
            saveShoe()
        }


        return binding.root
    }




    private fun saveShoe() {
        val newShoe = (Shoe(
           binding.shoeNameEditText.text.toString(),
           binding.shoeSizeEditText.text.toString().toDouble(),
           binding.shoeCompanyEditText.text.toString(),
           binding.shoeDescriptionTextView.text.toString(),
           listOf("shoe")
       ))

        viewModel.addNewShoe(newShoe)
        navigateToShoeList()
    }

    private fun navigateToShoeList() {
        this.findNavController().popBackStack(R.id.shoeListFragment, false)
    }

}