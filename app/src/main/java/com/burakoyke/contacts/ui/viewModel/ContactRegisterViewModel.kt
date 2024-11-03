package com.burakoyke.contacts.ui.viewModel

import androidx.lifecycle.ViewModel
import com.burakoyke.contacts.data.repository.ContactRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactRegisterViewModel : ViewModel() {
    var crepo = ContactRepository()
    fun registerContact(name : String, phone : String) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.registerContact(name,phone)
        }

    }
}