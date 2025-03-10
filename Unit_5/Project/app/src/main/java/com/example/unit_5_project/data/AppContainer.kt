package com.example.unit_5_project.data

import com.example.unit_5_project.network.BookApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val booksRepository : BooksRepository
}
class DefaultAppContainer : AppContainer {
    private val baseUrl =
        "https://www.googleapis.com"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json{ignoreUnknownKeys=true}.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }

    override val booksRepository: BooksRepository by lazy {
        NetworkBookRepository(retrofitService)
    }

}