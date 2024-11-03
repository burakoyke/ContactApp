package com.burakoyke.contacts.data.repository

import com.burakoyke.contacts.data.datasource.ContactDataSource
import com.burakoyke.contacts.data.entity.Contacts


class ContactRepository {
    var cds = ContactDataSource()
    suspend fun registerContact(name : String, phone : String) = cds.registerContact(name,phone)
    suspend fun updateContact(id : Int, name : String, phone : String) = cds.updateContact(id,name,phone)
    suspend fun delete(id : Int) = cds.delete(id)
    suspend fun loadContacts() : List<Contacts> = cds.loadContacts()
    suspend fun search(searchWord : String) : List<Contacts> = cds.search(searchWord)
}