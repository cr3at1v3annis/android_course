package com.example.unit_5_project.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.example.unit_5_project.R
import com.example.unit_5_project.model.Book
import com.example.unit_5_project.ui.theme.Unit_5_ProjectTheme
import coil.compose.AsyncImage
import com.example.unit_5_project.model.BookList

@Composable
fun HomeScreen(
    bookUiState: BookUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (bookUiState) {
        is BookUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is BookUiState.Success -> PhotosGridScreen(
            bookUiState.photos, modifier = modifier.fillMaxWidth()
        )
        is BookUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())

    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }

    }
}


/**
 * ResultScreen displaying number of photos retrieved.
 */
@Composable
fun ResultScreen(photos: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = photos)
    }
}

@Composable
fun BookCard(book: Book, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.imgSrc)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.books_photo),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            modifier = Modifier.fillMaxWidth()
        )
    }

}


@Composable
fun PhotosGridScreen(
    photos: BookList,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Text(text=photos.totalItens.toString())
//    LazyVerticalGrid(
//        columns = GridCells.Adaptive(150.dp),
//        modifier = modifier.padding(horizontal = 4.dp),
//        contentPadding = contentPadding,
//    ) {
//        items(items = photos, key = { photo -> photo.id }) {
//                photo -> BookCard(photo, modifier = modifier
//            .padding(4.dp)
//            .fillMaxWidth()
//            .aspectRatio(1.5f)
//        )
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    Unit_5_ProjectTheme() {
        //val mockData = List(10) { Book("$it", "") }
        //PhotosGridScreen(mockData)
    }
}