package com.burakoyke.contacts.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.burakoyke.contacts.R
import com.burakoyke.contacts.databinding.FragmentContactDetailBinding
import com.burakoyke.contacts.databinding.FragmentMainPageBinding
import com.burakoyke.contacts.ui.viewModel.ContactDetailViewModel

class ContactDetailFragment : Fragment() {

    private lateinit var binding : FragmentContactDetailBinding
    private lateinit var viewModel : ContactDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_contact_detail,container,false)
        binding.contactUpdateToolbar = "Contact Detail"
        binding.contactDetailFragment = this
        val bundle : ContactDetailFragmentArgs by navArgs()
        val receivedContact = bundle.contact
        binding.contact = receivedContact

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : ContactDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun updateContact(id : Int, name : String, phone : String){
        viewModel.updateContact(id,name,phone)
    }
}