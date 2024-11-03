package com.burakoyke.contacts.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.burakoyke.contacts.data.entity.Contacts
import com.burakoyke.contacts.data.repository.ContactRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel : ViewModel() {
    var contactList = MutableLiveData<List<Contacts>>()
    var crepo = ContactRepository()
    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.delete(id)
        }
    }
    fun loadContacts(){
        CoroutineScope(Dispatchers.Main).launch {
            contactList.value = crepo.loadContacts()
        }
    }

    fun search(searchWord : String){
        CoroutineScope(Dispatchers.Main).launch {
            contactList.value = crepo.search(searchWord)
        }
    }

    init {
        loadContacts()
    }
}