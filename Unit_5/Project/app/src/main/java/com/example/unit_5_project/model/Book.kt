package com.example.unit_5_project.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val kind: String,
    val id: String,
    val etag: String,
    val setLink: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)
@Serializable
data class BookList(
    val kind: String,
    val totalItens: Int
)