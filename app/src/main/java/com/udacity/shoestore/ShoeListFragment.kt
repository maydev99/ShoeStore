package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemCardBinding
import timber.log.Timber


class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.shoeListFab.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }

        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        observeData()

        return binding.root
    }



    private fun observeData() {

        viewModel.shoesData.observe(viewLifecycleOwner, Observer { newShoes ->

            for (shoe in newShoes) {
                val listBinding = ShoeItemCardBinding.inflate(layoutInflater, null, false)
                listBinding.shoe = shoe
                Timber.i("Shoe Data: $shoe")
                binding.shoeList.addView(listBinding.root)

            }

        })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_logout -> {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}