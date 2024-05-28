package com.nghia.dictionaryapp.di

import com.nghia.dictionaryapp.data.repository.DictionaryRepositoryImp
import com.nghia.dictionaryapp.domain.repository.DictionaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDictionaryRepository(
        dictionaryRepositoryImp: DictionaryRepositoryImp
    ): DictionaryRepository
}