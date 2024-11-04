package com.burakoyke.contacts.data.datasource

import android.util.Log
import com.burakoyke.contacts.data.entity.Contacts
import com.burakoyke.contacts.retrofit.ContactDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactDataSource (var cdao : ContactDao) {
    suspend fun registerContact(name : String, phone : String){
        cdao.registerContact(name,phone)
    }

    suspend fun updateContact(id : Int, name : String, phone : String){
        cdao.updateContact(id,name,phone)
    }
    suspend fun delete(id : Int){
        cdao.delete(id)
    }

    suspend fun loadContacts() : List<Contacts> =
        withContext(Dispatchers.IO){
            return@withContext cdao.loadContacts().kisiler
        }
    suspend fun search(searchWord: String): List<Contacts> =
        withContext(Dispatchers.IO) {
            return@withContext cdao.search(searchWord).kisiler
        }
}