package com.burakoyke.contacts.data.datasource

import android.util.Log
import com.burakoyke.contacts.data.entity.Contacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactDataSource {
    suspend fun registerContact(name : String, phone : String){
        Log.e("Contact", "Name : $name, Phone : $phone")
    }

    suspend fun updateContact(id : Int, name : String, phone : String){
        Log.e("Contact", "Name : $name, Phone : $phone, ID : $id")
    }
    suspend fun delete(id : Int){
        Log.e("Contact", "ID : $id")
    }

    suspend fun loadContacts() : List<Contacts> =
        withContext(Dispatchers.IO){
            val contactList = ArrayList<Contacts>()
            val c1 = Contacts(1,"Burak","05555555555")
            val c2 = Contacts(2,"Ali","05555555555")
            contactList.add(c1)
            contactList.add(c2)
            return@withContext contactList
        }
    suspend fun search(searchWord : String) : List<Contacts> =
        withContext(Dispatchers.IO){
            val contactList = ArrayList<Contacts>()
            val c1 = Contacts(1,"Ahmet","05555555555")
            contactList.add(c1)
        return@withContext contactList
    }
}