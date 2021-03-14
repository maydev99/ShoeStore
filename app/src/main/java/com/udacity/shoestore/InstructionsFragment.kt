package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding


class InstructionsFragment : Fragment() {
    lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstructionsBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

}