package com.nghia.dictionaryapp.data.repository

import android.app.Application
import com.nghia.dictionaryapp.R
import com.nghia.dictionaryapp.data.api.DictionaryApi
import com.nghia.dictionaryapp.data.mapper.toWordItem
import com.nghia.dictionaryapp.domain.model.WordItem
import com.nghia.dictionaryapp.domain.repository.DictionaryRepository
import com.nghia.dictionaryapp.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import retrofit2.HttpException
import java.io.IOException

class DictionaryRepositoryImp @Inject constructor(
    private val dictionaryApi: DictionaryApi,
    private val application: Application
): DictionaryRepository {
    override suspend fun getWordResult(
        word: String
    ): Flow<Result<WordItem>> {
        return flow {
            emit(Result.Loading(true))

            val remoteWordResultDto = try {
                dictionaryApi.getWordResult(word)
            }catch (e: HttpException){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.http_error_occurred)))
                emit(Result.Loading(false))
                return@flow
            }catch (e: IOException){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.io_error_occurred)))
                emit(Result.Loading(false))
                return@flow
            }catch (e: Exception){
                e.printStackTrace()
                emit(Result.Error(application.getString(R.string.error_occurred)))
                emit(Result.Loading(false))
                return@flow
            }

            remoteWordResultDto?.let {wordResultDto ->
                wordResultDto[0]?.let {wordItemDto->
                    emit(Result.Success(wordItemDto.toWordItem()))
                    emit(Result.Loading(false))
                    return@flow
                }

            }

            emit(Result.Error(application.getString(R.string.cannot_get_the_word)))
            emit(Result.Loading(false))
        }
    }


}