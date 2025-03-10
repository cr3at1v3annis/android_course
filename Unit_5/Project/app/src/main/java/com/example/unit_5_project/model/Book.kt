package com.example.unit_5_project.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
)

@Serializable
data class VolumeInfo(
    val title: String,
    val imageLinks : ImageLinks,
)

@Serializable
data class Book(
    val kind: String,
    val id: String,
    val etag: String,
    val selfLink: String,
    val volumeInfo : VolumeInfo
)
@Serializable
data class BookList(
    val kind: String,
    val totalItems: Int,
    val items : List<Book>
)