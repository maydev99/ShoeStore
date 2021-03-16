package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_item_card.view.*
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


        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        binding.lifecycleOwner = this
        observeData()

        setHasOptionsMenu(true)
        return binding.root
    }

    private fun observeData() {

        viewModel.shoesData.observe(viewLifecycleOwner, Observer { newShoes ->
            newShoes.forEach {
                Timber.i("LISTFRAG: ${it.name}")
                addShoeToLayout(it)

            }

        })
    }

    private fun addShoeToLayout(item: Shoe) {
        val shoeItemCard = layoutInflater.inflate(R.layout.shoe_item_card, binding.shoeList, false)

        shoeItemCard.apply {
            item_shoe_text_view.text = item.name
            item_company_text_view.text = item.company
            item_size_text_view.text = item.size.toString()
            item_description_text_view.text = item.description
            binding.shoeList.addView(shoeItemCard)
        }


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