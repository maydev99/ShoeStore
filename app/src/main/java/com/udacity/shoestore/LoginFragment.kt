package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.loginButton.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            NavHostFragment.findNavController(this).navigate(action)

        }

        binding.createAccountButton.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }


        return binding.root
    }

}