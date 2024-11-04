package com.burakoyke.contacts.di

import com.burakoyke.contacts.data.datasource.ContactDataSource
import com.burakoyke.contacts.data.repository.ContactRepository
import com.burakoyke.contacts.retrofit.ApiUtils
import com.burakoyke.contacts.retrofit.ContactDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactDataSource(cdao : ContactDao) : ContactDataSource{
        return ContactDataSource(cdao)
    }

    @Provides
    @Singleton
    fun provideContactRepository(cds : ContactDataSource) : ContactRepository{
        return ContactRepository(cds)
    }

    @Provides
    @Singleton
    fun provideContactDao() : ContactDao{
        return ApiUtils.getContactDao()
    }
}