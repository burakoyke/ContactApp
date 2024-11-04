package com.burakoyke.contacts.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.burakoyke.contacts.data.entity.Contacts
import com.burakoyke.contacts.data.repository.ContactRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel  @Inject constructor(var crepo : ContactRepository) : ViewModel() {
    var contactList = MutableLiveData<List<Contacts>>()
    fun delete(id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            crepo.delete(id)
            loadContacts()
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