package com.burakoyke.contacts.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getContactDao() : ContactDao {
            return RetrofitClient.getClient(BASE_URL).create(ContactDao::class.java)
        }
    }
}