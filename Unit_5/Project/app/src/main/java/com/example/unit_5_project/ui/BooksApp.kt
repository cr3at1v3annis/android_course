package com.example.unit_5_project.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unit_5_project.model.Book
import com.example.unit_5_project.ui.screens.BooksViewModel
import com.example.unit_5_project.ui.screens.HomeScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val bookViewModel: BooksViewModel = viewModel(factory = BooksViewModel.Factory)
            HomeScreen(
                bookUiState = bookViewModel.bookUiState,
                retryAction = bookViewModel::getBooks,
                contentPadding = it,
            )
        }
    }
}
