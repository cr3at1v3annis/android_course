package com.example.unit_5_project.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.unit_5_project.data.BooksRepository
import com.example.unit_5_project.BooksApplication
import com.example.unit_5_project.model.Book
import com.example.unit_5_project.model.BookList
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface BookUiState {
    data class Success(val photos: BookList) : BookUiState
    object Error : BookUiState
    object Loading : BookUiState
}


class BooksViewModel(private val booksRepository: BooksRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var bookUiState: BookUiState by mutableStateOf(BookUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getBooks()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getBooks() {
        viewModelScope.launch {
            bookUiState = BookUiState.Loading
            bookUiState = try {
                BookUiState.Success(booksRepository.getBooks())
            } catch (e: IOException) {
                BookUiState.Error
            } catch (e: HttpException) {
                BookUiState.Error
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BooksApplication)
                val booksRepository = application.container.booksRepository
                BooksViewModel(booksRepository = booksRepository)
            }
        }
    }

}