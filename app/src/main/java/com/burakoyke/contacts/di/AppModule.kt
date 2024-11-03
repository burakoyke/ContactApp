package com.burakoyke.contacts.di

import com.burakoyke.contacts.data.datasource.ContactDataSource
import com.burakoyke.contacts.data.repository.ContactRepository
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
    fun provideContactDataSource() : ContactDataSource{
        return ContactDataSource()
    }

    @Provides
    @Singleton
    fun provideContactRepository(cds : ContactDataSource) : ContactRepository{
        return ContactRepository(cds)
    }
}