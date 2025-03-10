package com.example.unit_5_project.data

import com.example.unit_5_project.model.Book
import com.example.unit_5_project.model.BookList
import com.example.unit_5_project.network.BookApiService

interface BooksRepository {
    suspend fun getBooks(): BookList
}
class NetworkBookRepository(
    private val booksApiService: BookApiService
) : BooksRepository {
    override suspend fun getBooks(): BookList  = booksApiService.getBooks()
}