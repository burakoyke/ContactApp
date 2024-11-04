package com.burakoyke.contacts.retrofit

import com.burakoyke.contacts.data.entity.CRUDResponse
import com.burakoyke.contacts.data.entity.ContactResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ContactDao {
    //http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    //http://kasimadalan.pe.hu/ ==> base url
    //kisiler/tum_kisiler.php ==> webservice url
    @GET("kisiler/tum_kisiler.php")
    suspend fun loadContacts() : ContactResponse

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun search(@Field("kisi_ad") aramaKelimesi : String) : ContactResponse

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    suspend fun registerContact(@Field("kisi_ad") kisi_ad : String,
                       @Field("kisi_tel") kisi_tel : String) : CRUDResponse

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    suspend fun updateContact(@Field("kisi_id") kisi_id : Int,
                         @Field("kisi_ad") kisi_ad : String,
                         @Field("kisi_tel") kisi_tel : String) : CRUDResponse

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun delete(@Field("kisi_id") kisi_id : Int) : CRUDResponse

}