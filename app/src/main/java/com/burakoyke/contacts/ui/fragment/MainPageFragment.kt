package com.burakoyke.contacts.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.burakoyke.contacts.R
import com.burakoyke.contacts.data.entity.Contacts
import com.burakoyke.contacts.databinding.FragmentMainPageBinding
import com.burakoyke.contacts.ui.adapter.ContactAdapter
import com.burakoyke.contacts.ui.fragment.MainPageFragmentDirections
import com.burakoyke.contacts.ui.viewModel.MainPageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainPageFragment : Fragment() {


    private lateinit var binding : FragmentMainPageBinding
    private lateinit var viewModel : MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_page,container,false)
        binding.mainPageFragment = this

        binding.contactMainPageToolbar = "Contacts"


        viewModel.contactList.observe(viewLifecycleOwner){
            val adapter = ContactAdapter(requireContext(),it,viewModel)
            binding.contactAdapter = adapter
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(p0: String): Boolean {
                viewModel.search(p0)
                return true

            }

            override fun onQueryTextSubmit(p0: String): Boolean {
                viewModel.search(p0)
                return false
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : MainPageViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabButton(it : View){
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_mainPageFragment_to_contactRegisterFragment)
        }
    }

}