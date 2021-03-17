package com.udacity.shoestore.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
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

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.cancelButton.setOnClickListener {
            navigateToShoeList()
        }

        binding.saveButton.setOnClickListener {

            saveShoe()
        }


        return binding.root
    }


    private fun saveShoe() {

        if (TextUtils.isEmpty(binding.shoeNameEditText.text.toString()) ||
            TextUtils.isEmpty(binding.shoeCompanyEditText.text.toString()) ||
            TextUtils.isEmpty((binding.descriptionEditText.text.toString())) ||
            TextUtils.isEmpty(binding.shoeSizeEditText.text.toString())
        ) {
            Toast.makeText(requireContext(), "missing information", Toast.LENGTH_SHORT).show()
        } else {
            val newShoe = (Shoe(
                binding.shoeNameEditText.text.toString(),
                binding.shoeSizeEditText.text.toString().toDouble(),
                binding.shoeCompanyEditText.text.toString(),
                binding.descriptionEditText.text.toString(),
                listOf("shoe")
            ))
            viewModel.addNewShoe(newShoe)
            navigateToShoeList()
        }
    }

    private fun navigateToShoeList() {
        this.findNavController().popBackStack(R.id.shoeListFragment, false)

    }

}