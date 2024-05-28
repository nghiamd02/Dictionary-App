package com.nghia.dictionaryapp.data.dto

data class MeaningDto(
    val definitions: List<DefinitionDto>? = null,
    val partOfSpeech: String? = null,
)