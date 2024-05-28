package com.nghia.dictionaryapp.presentation

import com.nghia.dictionaryapp.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",
    val wordItem: WordItem? = null,
)
