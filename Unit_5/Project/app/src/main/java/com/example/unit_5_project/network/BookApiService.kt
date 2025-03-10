package com.example.unit_5_project.network

import com.example.unit_5_project.model.Book
import com.example.unit_5_project.model.BookList
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

interface BookApiService {
    @GET("books/v1/volumes?q=jazz+history")
    suspend fun getBooks(): BookList
}
