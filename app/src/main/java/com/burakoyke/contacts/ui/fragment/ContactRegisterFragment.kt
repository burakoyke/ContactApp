package com.burakoyke.contacts.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.burakoyke.contacts.R
import com.burakoyke.contacts.databinding.FragmentContactDetailBinding
import com.burakoyke.contacts.databinding.FragmentContactRegisterBinding
import com.burakoyke.contacts.databinding.FragmentMainPageBinding
import com.burakoyke.contacts.ui.viewModel.ContactRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class ContactRegisterFragment : Fragment() {
    private lateinit var binding : FragmentContactRegisterBinding
    private lateinit var viewModel : ContactRegisterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_contact_register,container,false)
        binding.contactRegisterToolbar = "Contact Register"
        binding.contactRegisterFragment = this
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : ContactRegisterViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun registerContact(name : String, phone : String){
       viewModel.registerContact(name,phone)
    }



}