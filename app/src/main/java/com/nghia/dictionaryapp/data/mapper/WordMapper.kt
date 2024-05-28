package com.nghia.dictionaryapp.data.mapper

import com.nghia.dictionaryapp.data.dto.DefinitionDto
import com.nghia.dictionaryapp.data.dto.MeaningDto
import com.nghia.dictionaryapp.data.dto.WordItemDto
import com.nghia.dictionaryapp.domain.model.Definition
import com.nghia.dictionaryapp.domain.model.Meaning
import com.nghia.dictionaryapp.domain.model.WordItem

fun WordItemDto.toWordItem() = WordItem(
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    }?: emptyList(),
    phonetic = phonetic?: ""
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech?: ""
)

fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition(
    definition = definitionDto?.definition?: "",
    example = definitionDto?.example ?: ""
)