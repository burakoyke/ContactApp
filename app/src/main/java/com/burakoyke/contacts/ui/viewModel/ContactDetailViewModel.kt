package com.burakoyke.contacts.ui.viewModel

import androidx.lifecycle.ViewModel
import com.burakoyke.contacts.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactDetailViewModel @Inject constructor(var crepo : ContactRepository) : ViewModel() {
    fun updateContact(id:Int, name : String, phone : String) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.updateContact(id,name,phone)
        }

    }
}