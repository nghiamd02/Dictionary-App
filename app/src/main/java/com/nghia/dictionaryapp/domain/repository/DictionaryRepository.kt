package com.nghia.dictionaryapp.domain.repository

import com.nghia.dictionaryapp.domain.model.WordItem
import com.nghia.dictionaryapp.util.Result
import kotlinx.coroutines.flow.Flow


interface DictionaryRepository {

    suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>>
}